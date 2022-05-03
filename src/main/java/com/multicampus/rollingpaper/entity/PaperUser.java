package com.multicampus.rollingpaper.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class PaperUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "paper_user_id")
    private Long paperUserId;

    private String name;

    private String email;

    private String password;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany
    @JoinColumn(name = "userId")
    @ToString.Exclude
    private List<PostInfo> postInfos=new ArrayList<>();

    public void addPost(PostInfo postInfo){
        postInfos.add(postInfo);
    }
    public void removePost(PostInfo postInfo){
        postInfos.remove(postInfo);
    }
}
