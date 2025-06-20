package com.blog.blog_app_backend.repositories;

import com.blog.blog_app_backend.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo  extends JpaRepository<Comment, Integer> {

}
