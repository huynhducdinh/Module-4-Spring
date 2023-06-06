package com.example.bai1.repository;

import com.example.bai1.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
