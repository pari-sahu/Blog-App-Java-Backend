package com.blog.blog_app_backend.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {

    private String username;

    private String password;

}
