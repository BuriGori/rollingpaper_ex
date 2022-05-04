package com.multicampus.rollingpaper.service;

import com.multicampus.rollingpaper.entity.PaperUser;
import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.repository.PaperUserRepository;
import com.multicampus.rollingpaper.repository.PostInfoRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class PaperUserService {

    @Autowired
    private PaperUserRepository paperUserRepository;

    public PaperUser signIn(PaperUser paperUser){
        return paperUserRepository.save(paperUser);
    }

    public Boolean loginCheck(PaperUser paperUser){
        PaperUser user = paperUserRepository.findByEmail(paperUser.getEmail());
        if(user == null) return false;
        if(user.getPassword()==paperUser.getPassword())return true;
        return false;
    }

    public PaperUser updatePaperUser(PaperUser paperUser){
        PaperUser user = paperUserRepository.getById(paperUser.getId());
        user.setName(paperUser.getName());
        user.setEmail(paperUser.getEmail());
        user.setPassword(paperUser.getPassword());
        user.setImageUrl(paperUser.getImageUrl());
        return paperUserRepository.save(user);
    }

    public ResponseEntity<?> deleteUser(PaperUser paperUser){
        PaperUser user = paperUserRepository.findByEmail(paperUser.getEmail());
        if(user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        paperUserRepository.delete(paperUser);
        return ResponseEntity.ok().build();
    }

}
