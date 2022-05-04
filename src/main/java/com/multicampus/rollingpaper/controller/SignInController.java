package com.multicampus.rollingpaper.controller;

import com.multicampus.rollingpaper.entity.PaperUser;
import com.multicampus.rollingpaper.service.PaperUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signin")
public class SignInController {

    @Autowired
    public PaperUserService paperUserService;

    @PostMapping("add")
    public PaperUser signIn(@RequestBody PaperUser paperUser){
        return paperUserService.signIn(paperUser);
    }



}
