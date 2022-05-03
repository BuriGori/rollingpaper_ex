package com.multicampus.rollingpaper.repository;

import com.multicampus.rollingpaper.entity.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PostInfoRepository extends JpaRepository<PostInfo,Long> {
}
