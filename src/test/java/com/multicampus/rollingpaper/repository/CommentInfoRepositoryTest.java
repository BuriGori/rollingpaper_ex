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


    @Test
    public void beforeSetting(){
        PaperUser paperUser = new PaperUser();
        paperUser.setName("첫 유저");
        paperUser.setPassword("1234");
        paperUser.setEmail("user@email.com");
        paperUser.setImageUrl("null");
        paperUserService.signIn(paperUser);

//        log.info(String.valueOf(paperUserRepository.findById(1L)));
        System.out.println(paperUserRepository.findById(1L).get().toString());
        log.info("-----------------------");


        PostInfo postInfo = new PostInfo();
        postInfo.setPostContent("이날을 위해서");
        postInfo.setTargetDate(LocalDateTime.now());
        postInfo.setUserId(1L);
        postInfoService.createPost(postInfo);

        PostInfo postInfo2 = new PostInfo();
        postInfo2.setPostContent("이날을 위해서???");
        postInfo2.setTargetDate(LocalDateTime.now());
        postInfo2.setUserId(1L);
        postInfoService.createPost(postInfo2);

//        log.info(String.valueOf(paperUserRepository.findById(1L)));
        System.out.println(paperUserRepository.findById(1L).get().toString());
        paperUserRepository.findById(1L).get().getPostInfos().forEach(System.out::println);
//        log.info(String.valueOf(postInfoRepository.findById(2L)));
//        System.out.println(postInfoRepository.findById(2L).get().toString());
        log.info("-----------------------");


        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setAuthor("작성자1");
        commentInfo.setText("작성글1");
        commentInfo.setPostInfoId(2L);
        commnetInfoService.createComment(commentInfo);

        CommentInfo commentInfo2 = new CommentInfo();
        commentInfo2.setAuthor("작성자2");
        commentInfo2.setText("작성글2");
        commentInfo2.setPostInfoId(2L);
        commnetInfoService.createComment(commentInfo2);

        CommentInfo commentInfo3 = new CommentInfo();
        commentInfo3.setAuthor("작성자3");
        commentInfo3.setText("작성글3");
        commentInfo3.setPostInfoId(3L);
        commnetInfoService.createComment(commentInfo3);

        System.out.println(paperUserRepository.findById(1L).get().toString());
        paperUserRepository.findById(1L).get().getPostInfos().forEach(System.out::println);
        postInfoRepository.findById(2L).get().getCommentInfos().forEach(System.out::println);
        postInfoRepository.findById(3L).get().getCommentInfos().forEach(System.out::println);
//        log.info(String.valueOf(paperUserRepository.findById(1L)));
//        log.info(String.valueOf(postInfoRepository.findById(2L)));
//        log.info(String.valueOf(commentInfoRepository.findById(3L)));

    }


    @Test
    @Disabled
    public void commnetTest(){
        log.info("test!");






    }



}