package com.pariuteam.tetriaBack.domain.usecases;

import com.pariuteam.tetriaBack.persistence.entities.User;

import java.util.List;

public interface GetRankingUseCase {

    List<User> getRanking();
}
