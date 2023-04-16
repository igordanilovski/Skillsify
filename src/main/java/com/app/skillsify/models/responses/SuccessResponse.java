package com.app.skillsify.models.responses;

public class SuccessResponse<T> {
    private final String message;
    private T object;

    public SuccessResponse() {
        this.message = "OK";
    }

    public SuccessResponse(T object, String message) {
        this.object = object;
        this.message = message;
    }
}
