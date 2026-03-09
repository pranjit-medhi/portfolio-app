package com.main.exception;


import com.main.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleResourceNotFoundException(ResourceNotFound ex){
        ErrorResponse e = new ErrorResponse(ex.getMessage(), ex.getStatus());
        return ResponseEntity
                .status(ex.getStatus())
                .body(ApiResponse.error(ex.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<ErrorResponse>> handleBadRequestException(BadRequestException ex){
        ErrorResponse e = new ErrorResponse(ex.getMessage(), ex.getStatus());
        return ResponseEntity
                .status(ex.getStatus())
                .body(ApiResponse.error(ex.getMessage()));
    }
}

