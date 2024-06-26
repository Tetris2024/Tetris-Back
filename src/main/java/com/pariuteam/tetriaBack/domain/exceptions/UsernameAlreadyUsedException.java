package com.pariuteam.tetriaBack.domain.exceptions;

public class UsernameAlreadyUsedException extends CustomException {

    public UsernameAlreadyUsedException() {
        super("LOGIN_USED", "username already used");
    }
}
