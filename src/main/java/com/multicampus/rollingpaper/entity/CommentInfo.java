package com.multicampus.rollingpaper.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class CommentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comment_info_id")
    private Long commentInfoId;

    private Long postInfoId;

    private String author;

    private String text;
}
