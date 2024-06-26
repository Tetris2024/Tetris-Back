package com.pariuteam.tetriaBack.domain.services;

import com.pariuteam.tetriaBack.domain.exceptions.UserNotFoundException;
import com.pariuteam.tetriaBack.domain.exceptions.UsernameAlreadyUsedException;
import com.pariuteam.tetriaBack.domain.exceptions.WrongCredentialsException;
import com.pariuteam.tetriaBack.domain.usecases.GetRankingUseCase;
import com.pariuteam.tetriaBack.domain.usecases.GetUserIdUseCase;
import com.pariuteam.tetriaBack.domain.usecases.RegisterUserUseCase;
import com.pariuteam.tetriaBack.domain.usecases.UpdateUserBestScoreUseCase;
import com.pariuteam.tetriaBack.persistence.entities.User;
import com.pariuteam.tetriaBack.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements GetUserIdUseCase, RegisterUserUseCase, UpdateUserBestScoreUseCase, GetRankingUseCase {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Long getUserId(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isEmpty() || !user.get().getPassword().equals(password) ){
            throw new WrongCredentialsException();
        }

        return user.get().getId();
    }

    @Override
    public Long registerUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            throw new UsernameAlreadyUsedException();
        }
        else{
            User registeredUser = userRepository.saveAndFlush(User.builder()
                    .username(username)
                    .password(password)
                    .bestScore(0)
                    .build());

            return registeredUser.getId();
        }
    }

    @Override
    public void updateUserBestScore(Long id, Long score) {
        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isEmpty()){
            throw new UserNotFoundException();
        }
        User user = userOpt.get();
        if(user.getBestScore()<score){
            user.setBestScore(score);
            userRepository.saveAndFlush(user);
        }
    }

    @Override
    public List<User> getRanking() {
        return userRepository.getRanking();
    }
}
