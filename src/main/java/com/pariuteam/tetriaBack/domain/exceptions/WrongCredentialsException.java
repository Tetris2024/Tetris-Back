package com.pariuteam.tetriaBack.domain.exceptions;

public class WrongCredentialsException extends CustomException {

    public WrongCredentialsException() {
        super("WRONG_CREDENTIALS", "wrong credentials");
    }
}
