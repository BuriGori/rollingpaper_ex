package com.multicampus.rollingpaper.repository;

import com.multicampus.rollingpaper.entity.CommentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CommentInfoRepository extends JpaRepository<CommentInfo,Long> {
}
