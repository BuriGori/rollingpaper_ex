package com.multicampus.rollingpaper.repository;

import com.multicampus.rollingpaper.entity.CommentInfo;
import com.multicampus.rollingpaper.entity.PaperUser;
import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.service.CommnetInfoService;
import com.multicampus.rollingpaper.service.PaperUserService;
import com.multicampus.rollingpaper.service.PostInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
@Transactional
class CommentInfoRepositoryTest {
    @Autowired
    private CommentInfoRepository commentInfoRepository;
    @Autowired
    private PostInfoRepository postInfoRepository;
    @Autowired
    private PaperUserRepository paperUserRepository;

    @Autowired
    private CommnetInfoService commnetInfoService;
    @Autowired
    private PostInfoService postInfoService;
    @Autowired
    private PaperUserService paperUserService;


    @BeforeEach
    public void beforeSetting(){
        PaperUser paperUser = new PaperUser();
        paperUser.setName("첫 유저");
        paperUser.setPassword("1234");
        paperUser.setEmail("user@email.com");
        paperUser.setImageUrl("null");
        paperUserService.signIn(paperUser);

        log.info(String.valueOf(paperUserRepository.getById(1L)));
        log.info("-----------------------");


        PostInfo postInfo = new PostInfo();
        postInfo.setPostContent("이날을 위해서");
        postInfo.setTargetDate(LocalDateTime.now());
        postInfo.setUserId(1L);
        postInfoService.createPost(postInfo);

        log.info(String.valueOf(paperUserRepository.getById(1L)));
        log.info(String.valueOf(postInfoRepository.getById(2L)));
        log.info("-----------------------");

        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setAuthor("작성자");
        commentInfo.setText("작성글");
        commentInfo.setPostInfoId(2L);
        commnetInfoService.createComment(commentInfo);

        log.info(String.valueOf(paperUserRepository.getById(1L)));
        log.info(String.valueOf(postInfoRepository.getById(2L)));
        log.info(String.valueOf(commentInfoRepository.getById(3L)));

    }


    @Test
    public void commnetTest(){
        log.info("test!");






    }



}