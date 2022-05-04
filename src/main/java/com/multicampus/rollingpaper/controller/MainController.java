package com.multicampus.rollingpaper.controller;

import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.service.PaperUserService;
import com.multicampus.rollingpaper.service.PostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    PaperUserService paperUserService;
    @Autowired
    PostInfoService postInfoService;

    @GetMapping("/{id}")
    public List<PostInfo> postListPage(@PathVariable Long id){
        return paperUserService.selectAllPost(id);
    }

}
