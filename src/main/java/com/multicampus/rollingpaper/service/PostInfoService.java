package com.multicampus.rollingpaper.service;

import com.multicampus.rollingpaper.entity.PaperUser;
import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.repository.PaperUserRepository;
import com.multicampus.rollingpaper.repository.PostInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostInfoService {

    @Autowired
    private PaperUserRepository paperUserRepository;
    @Autowired
    private PostInfoRepository postInfoRepository;

    public PostInfo createPost(PostInfo postInfo){
        Optional<PaperUser> optional = paperUserRepository.findById(postInfo.getUser().getId());
        if(!optional.isPresent()) return new PostInfo();
        PaperUser paperUser = optional.get();
        paperUser.addPost(postInfo);
        return postInfoRepository.save(postInfo);
    }

    public List<PostInfo> selectByUser(PaperUser paperUser){
        return postInfoRepository.findByUser(paperUser);
    }


    public ResponseEntity<?> deletePost(PostInfo postInfo){
        Optional<PostInfo> Optionalpost = postInfoRepository.findById(postInfo.getId());
        if(!Optionalpost.isPresent())return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        PostInfo post = Optionalpost.get();
        PaperUser user = paperUserRepository.getById(post.getUser().getId());
        user.removePost(post);
        postInfoRepository.delete(post);
        return ResponseEntity.ok().build();
    }
}
