package com.pariuteam.tetriaBack.api;

import com.pariuteam.tetriaBack.api.dto.EncryptedId;
import com.pariuteam.tetriaBack.api.dto.LoginCredentialsDto;
import com.pariuteam.tetriaBack.domain.usecases.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    @Autowired
    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/register")
    public ResponseEntity<EncryptedId> registerUser(@RequestBody LoginCredentialsDto credentials){
        return ResponseEntity.ok(EncryptedId.of(registerUserUseCase.registerUser(credentials.username(), credentials.password())));
    }
}
