package com.example.tasks.domain.dto;

public record ErrorResponse(
        int status, //Status code
        String message,//Error Message
        String details
) {
}
