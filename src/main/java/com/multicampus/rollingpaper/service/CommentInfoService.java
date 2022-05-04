package com.multicampus.rollingpaper.service;

import com.multicampus.rollingpaper.entity.CommentInfo;
import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.repository.CommentInfoRepository;
import com.multicampus.rollingpaper.repository.PostInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CommentInfoService {

    @Autowired
    private CommentInfoRepository commentInfoRepository;
    @Autowired
    private PostInfoRepository postInfoRepository;

    public CommentInfo createComment(CommentInfo commentInfo){
        Optional<PostInfo> optionalPost = postInfoRepository.findById(commentInfo.getPostInfo().getId());
        if(optionalPost==null){
            new RuntimeException().getMessage();
            log.info("포스트가 없습니다.");
            return new CommentInfo();
        }
        PostInfo post = optionalPost.get();
        post.addCommnet(commentInfo);
        return commentInfoRepository.save(commentInfo);
    }

    public PostInfo selectPostInfo(CommentInfo commentInfo){
        return commentInfo.getPostInfo();
    }

    public ResponseEntity<?> deleteComment(CommentInfo commentInfo){
        Optional<PostInfo> optionalPost = postInfoRepository.findById(commentInfo.getPostInfo().getId());
        if(optionalPost == null)return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        PostInfo post = optionalPost.get();
        post.removeCommnet(commentInfo);
        commentInfoRepository.delete(commentInfo);
        return ResponseEntity.ok().build();
    }
}
