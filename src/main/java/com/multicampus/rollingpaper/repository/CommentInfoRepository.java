package com.multicampus.rollingpaper.repository;

import com.multicampus.rollingpaper.entity.CommentInfo;
import com.multicampus.rollingpaper.entity.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentInfoRepository extends JpaRepository<CommentInfo,Long> {
    public List<CommentInfo> findByPostInfo(PostInfo postInfo);
}
