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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
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


    //REST API 관련 method
    public PostInfo createUserPost(Long id, PostInfo postInfo) {
        Optional<PaperUser> optional = paperUserRepository.findById(id);
        if(!optional.isPresent()){
            return new PostInfo();
        }
        PaperUser paperUser = optional.get();
        postInfo.setUser(paperUser);
        paperUser.addPost(postInfo);
        return postInfoRepository.save(postInfo);
    }

    public PostInfo updateUserPost(Long id, PostInfo postInfo, Long postId) {
        Optional<PaperUser> optional = paperUserRepository.findById(id);
        if(!optional.isPresent()){
            return new PostInfo();
        }
        PaperUser paperUser = optional.get();
        Optional<PostInfo> first = paperUser.getPostInfos().stream().filter(t -> t.getId() == postId).findFirst();
        if(!first.isPresent()){
            return new PostInfo();
        }
        PostInfo original = first.get();
        original.setTitle(postInfo.getTitle());
        original.setTargetDate(postInfo.getTargetDate());
        original.setPostContent(postInfo.getPostContent());
        return original;
    }

    public PostInfo deleteUserPost(Long id, Long postId) {
        Optional<PaperUser> optional = paperUserRepository.findById(id);
        if(!optional.isPresent()){
            return new PostInfo();
        }
        PaperUser paperUser = optional.get();
        Optional<PostInfo> first = paperUser.getPostInfos().stream().filter(t -> t.getId() == postId).findFirst();
        if(!first.isPresent()){
            return new PostInfo();
        }
        PostInfo original = first.get();
        paperUser.removePost(original);
        postInfoRepository.delete(original);
        return original;
    }

    public PaperUser selectUser(Long id) {
        Optional<PaperUser> optional = paperUserRepository.findById(id);
        if(!optional.isPresent()){
            return new PaperUser();
        }
        PaperUser paperUser = optional.get();
        return paperUser;
    }

    public PostInfo selectUserPost(Long id, Long postId) {
        Optional<PaperUser> optional = paperUserRepository.findById(id);
        if(!optional.isPresent()){
            return new PostInfo();
        }
        PaperUser paperUser = optional.get();
        Optional<PostInfo> first = paperUser.getPostInfos().stream().filter(t -> t.getId() == postId).findFirst();
        if(!first.isPresent()){
            return new PostInfo();
        }
        PostInfo original = first.get();
        return original;
    }
}
