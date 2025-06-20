package com.blog.blog_app_backend.repositories;

import com.blog.blog_app_backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
