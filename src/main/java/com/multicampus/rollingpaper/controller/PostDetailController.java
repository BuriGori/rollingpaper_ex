package com.multicampus.rollingpaper.controller;

import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.service.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
public class PostDetailController {

    @Autowired
    private PostInfoService postInfoService;

    @GetMapping("/{id}/{postId}")
    public PostInfo postDetailInfo(@PathVariable Long id, @PathVariable Long postId){
        return postInfoService.selectUserPost(id, postId);
    }
}
