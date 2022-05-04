package com.multicampus.rollingpaper.repository;

import com.multicampus.rollingpaper.entity.PaperUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperUserRepository extends JpaRepository<PaperUser, Long> {

    public PaperUser findByEmail(String email);
}
