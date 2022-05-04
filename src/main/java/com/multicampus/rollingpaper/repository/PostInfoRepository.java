package com.multicampus.rollingpaper.repository;

import com.multicampus.rollingpaper.entity.PaperUser;
import com.multicampus.rollingpaper.entity.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostInfoRepository extends JpaRepository<PostInfo,Long> {
    public List<PostInfo> findByUser(PaperUser user);
}
