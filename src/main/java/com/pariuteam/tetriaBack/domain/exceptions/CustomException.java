package com.pariuteam.tetriaBack.domain.exceptions;

public abstract class CustomException extends RuntimeException {
    private String code;
    private String message;

    public CustomException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
