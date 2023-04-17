package com.spring.callistoreview.exception;

public enum ErrorMessage {
    NOT_FOUND_PROFILE("유저를 찾을 수 없습니다."),
    NOT_MATCH_USER_COMPANY("재직중인 회사만 리뷰할 수 있습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
