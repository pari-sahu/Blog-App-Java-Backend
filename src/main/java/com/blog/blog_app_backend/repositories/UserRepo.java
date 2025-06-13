package com.blog.blog_app_backend.repositories;

import com.blog.blog_app_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
