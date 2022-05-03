package com.multicampus.rollingpaper.service;

import com.multicampus.rollingpaper.entity.CommentInfo;
import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.repository.CommentInfoRepository;
import com.multicampus.rollingpaper.repository.PostInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommnetInfoService {

    private final CommentInfoRepository commentInfoRepository;
    private final PostInfoRepository postInfoRepository;

    public CommentInfo createComment(CommentInfo commentInfo){
        Optional<PostInfo> optionalPost = postInfoRepository.findById(commentInfo.getPostInfoId());
        if(optionalPost==null){
            new RuntimeException().getMessage();
            log.info("포스트가 없습니다.");
            return new CommentInfo();
        }
        PostInfo post = optionalPost.get();
        post.addCommnet(commentInfo);
        return commentInfoRepository.save(commentInfo);
    }

    public ResponseEntity<?> deleteComment(CommentInfo commentInfo){
        Optional<PostInfo> optionalPost = postInfoRepository.findById(commentInfo.getPostInfoId());
        if(optionalPost == null)return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        PostInfo post = optionalPost.get();
        post.removeCommnet(commentInfo);
        commentInfoRepository.delete(commentInfo);
        return ResponseEntity.ok().build();
    }
}
