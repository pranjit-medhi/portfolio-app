package com.main.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public BadRequestException(String message) {
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
