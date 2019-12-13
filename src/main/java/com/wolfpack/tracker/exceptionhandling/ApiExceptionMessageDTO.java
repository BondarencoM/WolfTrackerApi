package com.wolfpack.tracker.exceptionhandling;

public class ApiExceptionMessageDTO {

    private String message;

    public ApiExceptionMessageDTO(Throwable cause) {
        message = cause.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public ApiExceptionMessageDTO setMessage(String message) {
        this.message = message;
        return this;
    }
}
