package com.multicampus.rollingpaper.controller;

import com.multicampus.rollingpaper.entity.PaperUser;
import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.service.PaperUserService;
import com.multicampus.rollingpaper.service.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PaperUserService paperUserService;
    @Autowired
    private PostInfoService postInfoService;

    @GetMapping("/{id}")
    public PaperUser postUser(@PathVariable Long id){
        return paperUserService.selectUser(id);
    }

    @PostMapping("/{id}")
    public PostInfo postList(@PathVariable Long id, @RequestBody PostInfo postInfo){
        return postInfoService.createUserPost(id, postInfo);
    }

    @PutMapping("/{id}/{postId}")
    public PostInfo postUpdate(@PathVariable Long id, @PathVariable Long postId, @RequestBody PostInfo postInfo){
        return postInfoService.updateUserPost(id, postInfo, postId);
    }

    @DeleteMapping("/{id}/{postId}")
    public PostInfo postDelete(@PathVariable Long id, @PathVariable Long postId) {
        return postInfoService.deleteUserPost(id, postId);
    }

}
