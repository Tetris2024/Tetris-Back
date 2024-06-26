package com.pariuteam.tetriaBack.api;

import com.pariuteam.tetriaBack.api.dto.EncryptedId;
import com.pariuteam.tetriaBack.api.dto.LoginCredentialsDto;
import com.pariuteam.tetriaBack.api.dto.UpdateBestScoreRequest;
import com.pariuteam.tetriaBack.api.dto.UserDto;
import com.pariuteam.tetriaBack.domain.usecases.GetRankingUseCase;
import com.pariuteam.tetriaBack.domain.usecases.GetUserIdUseCase;
import com.pariuteam.tetriaBack.domain.usecases.UpdateUserBestScoreUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController{
    @Autowired
    private UpdateUserBestScoreUseCase updateUserBestScoreUseCase;
    @Autowired
    private GetRankingUseCase getRankingUseCase;

    @PostMapping("/update")
    public ResponseEntity<?> updateUSerBestScore(@RequestBody UpdateBestScoreRequest request){
        updateUserBestScoreUseCase.updateUserBestScore(request.id().value(), request.score());
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<UserDto>> getRanking(){
        return ResponseEntity.ok(
                getRankingUseCase.getRanking().stream()
                .map(model -> UserDto.builder()
                        .username(model.getUsername())
                        .score(model.getBestScore()).build())
                .toList()
        );
    }
}
