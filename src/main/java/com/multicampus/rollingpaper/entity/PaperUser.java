package com.multicampus.rollingpaper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @JsonIgnore
    private List<PostInfo> postInfos=new ArrayList<>();

    public void addPost(PostInfo postInfo){
        postInfos.add(postInfo);
    }
    public void removePost(PostInfo postInfo){
        postInfos.remove(postInfo);
    }
}
