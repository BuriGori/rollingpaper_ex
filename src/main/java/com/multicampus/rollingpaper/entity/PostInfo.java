package com.multicampus.rollingpaper.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class PostInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postInfoId;

    private Long userId;

    private LocalDateTime targetDate;

    private String postContent;

    @OneToMany
    @JoinColumn(name = "postInfoId")
    @ToString.Exclude
    private List<CommentInfo> commentInfos = new ArrayList<>();

    public void addCommnet(CommentInfo commentInfo){
        commentInfos.add(commentInfo);
    }
    public void removeCommnet(CommentInfo commentInfo){
        commentInfos.remove(commentInfo);
    }
}
