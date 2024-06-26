package com.pariuteam.tetriaBack.domain.usecases;

public interface GetUserIdUseCase {

    Long getUserId(String login, String password);
}
