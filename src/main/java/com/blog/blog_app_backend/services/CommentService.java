package com.blog.blog_app_backend.services;

import com.blog.blog_app_backend.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);
}
