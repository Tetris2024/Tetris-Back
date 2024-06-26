package com.pariuteam.tetriaBack;

import com.pariuteam.tetriaBack.config.encryption.EncryptionServiceFactory;
import com.pariuteam.tetriaBack.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
       // userService.getUserId("","");
        EncryptionServiceFactory.getEncryptionUseCasesImplementation();
    }

}
