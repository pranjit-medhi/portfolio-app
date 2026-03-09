package com.main.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFound extends RuntimeException{
    private String message;
    private HttpStatus status;

    public ResourceNotFound(String message) {
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
