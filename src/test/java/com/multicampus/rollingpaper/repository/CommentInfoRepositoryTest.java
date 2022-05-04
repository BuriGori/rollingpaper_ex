package com.multicampus.rollingpaper.repository;

import com.multicampus.rollingpaper.entity.CommentInfo;
import com.multicampus.rollingpaper.entity.PaperUser;
import com.multicampus.rollingpaper.entity.PostInfo;
import com.multicampus.rollingpaper.service.CommentInfoService;
import com.multicampus.rollingpaper.service.PaperUserService;
import com.multicampus.rollingpaper.service.PostInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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
    private CommentInfoService commentInfoService;
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

        System.out.println(paperUserRepository.findByEmail("user@email.com").toString());
        log.info("-----------------------");

        PostInfo postInfo = new PostInfo();
        postInfo.setPostContent("이날을 위해서");
        postInfo.setTargetDate(LocalDateTime.now());
        postInfo.setUser(paperUser);
        postInfoService.createPost(postInfo);

        PostInfo postInfo2 = new PostInfo();
        postInfo2.setPostContent("이날을 위해서???");
        postInfo2.setTargetDate(LocalDateTime.now());
        postInfo2.setUser(paperUser);
        postInfoService.createPost(postInfo2);

        postInfoService.selectByUser(paperUserRepository.findByEmail("user@email.com")).forEach(System.out::println);
        log.info("-----------------------");

        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setAuthor("작성자1");
        commentInfo.setText("작성글1");
        commentInfo.setPostInfo(postInfo);
        commentInfoService.createComment(commentInfo);

        CommentInfo commentInfo2 = new CommentInfo();
        commentInfo2.setAuthor("작성자2");
        commentInfo2.setText("작성글2");
        commentInfo2.setPostInfo(postInfo);
        commentInfoService.createComment(commentInfo2);

        CommentInfo commentInfo3 = new CommentInfo();
        commentInfo3.setAuthor("작성자3");
        commentInfo3.setText("작성글3");
        commentInfo3.setPostInfo(postInfo2);
        commentInfoService.createComment(commentInfo3);

        postInfo.getCommentInfos().forEach(System.out::println);
        commentInfoRepository.findByPostInfo(postInfo).forEach(System.out::println);
        commentInfoRepository.findByPostInfo(postInfo2).forEach(System.out::println);
    }


    @Test
    @Disabled
    public void commnetTest(){
        log.info("test!");






    }



}