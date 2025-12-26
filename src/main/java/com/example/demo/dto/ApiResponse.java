package com.example.demo.dto;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;

    // Manual constructor for the 2-arg calls in GlobalExceptionHandler
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}