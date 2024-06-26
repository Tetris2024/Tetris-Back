package com.pariuteam.tetriaBack.api;

import com.pariuteam.tetriaBack.api.dto.EncryptedId;
import com.pariuteam.tetriaBack.api.dto.LoginCredentialsDto;
import com.pariuteam.tetriaBack.domain.usecases.GetUserIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {
    @Autowired
    private GetUserIdUseCase getUserIdUseCase;

    @PostMapping("/auth")
    public ResponseEntity<EncryptedId> authentUser(@RequestBody LoginCredentialsDto credentials){
        return ResponseEntity.ok(EncryptedId.of(getUserIdUseCase.getUserId(credentials.username(), credentials.password())));
    }
}
