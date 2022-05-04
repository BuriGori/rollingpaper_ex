package com.multicampus.rollingpaper.controller;

import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.service.PaperUserService;
import com.multicampus.rollingpaper.service.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PaperUserService paperUserService;
    @Autowired
    PostInfoService postInfoService;

    @PostMapping("/{id}")
    public PostInfo postList(@PathVariable Long id, @RequestBody PostInfo postInfo){
        return postInfoService.createUserPost(id, postInfo);
    }

    @PutMapping("/{id}/{postId}")
    public PostInfo postUpdate(@PathVariable Long id, @PathVariable Long postId, @RequestBody PostInfo postInfo){
        return postInfoService.updateUserPost(id, postInfo, postId);
    }



}
