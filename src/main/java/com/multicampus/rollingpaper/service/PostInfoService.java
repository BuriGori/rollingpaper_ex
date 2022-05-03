package com.multicampus.rollingpaper.service;

import com.multicampus.rollingpaper.entity.PaperUser;
import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.repository.PaperUserRepository;
import com.multicampus.rollingpaper.repository.PostInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostInfoService {

    private final PaperUserRepository paperUserRepository;
    private final PostInfoRepository postInfoRepository;

    public PostInfo createPost(PostInfo postInfo){
        PaperUser user = paperUserRepository.getById(postInfo.getUserId());
        user.addPost(postInfo);
        return postInfoRepository.save(postInfo);
    }

    public ResponseEntity<?> deletePost(PostInfo postInfo){
        Optional<PostInfo> Optionalpost = postInfoRepository.findById(postInfo.getPostInfoId());
        if(Optionalpost==null)return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        PostInfo post = Optionalpost.get();
        PaperUser user = paperUserRepository.getById(post.getUserId());
        user.removePost(post);
        postInfoRepository.delete(post);
        return ResponseEntity.ok().build();
    }
}
