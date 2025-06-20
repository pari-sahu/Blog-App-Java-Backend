package com.blog.blog_app_backend.exceptions;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);

    }

    public ApiException() {
        super();

    }

}
