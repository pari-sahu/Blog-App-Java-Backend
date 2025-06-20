package com.blog.blog_app_backend.payloads;

import lombok.Data;

@Data
public class JwtAuthResponse {

    private String token;

    private UserDto user;
}
