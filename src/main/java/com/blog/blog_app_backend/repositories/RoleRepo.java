package com.blog.blog_app_backend.repositories;

import com.blog.blog_app_backend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo  extends JpaRepository<Role, Integer> {

}
