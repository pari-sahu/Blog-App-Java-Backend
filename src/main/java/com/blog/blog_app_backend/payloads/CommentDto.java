package com.blog.blog_app_backend.payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {

    private int id;

    private String content;

}
