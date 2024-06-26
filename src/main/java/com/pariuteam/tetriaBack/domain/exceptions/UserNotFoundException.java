package com.pariuteam.tetriaBack.domain.exceptions;

public class UserNotFoundException extends CustomException {

    public UserNotFoundException() {
        super("USER_NOT_FOUND", "user not found");
    }
}
