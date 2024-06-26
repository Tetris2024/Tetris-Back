package com.pariuteam.tetriaBack.config.encryption;

import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class EncryptionServiceFactory {

    public static EncryptionUseCases getEncryptionUseCasesImplementation(){
        try {
            return new EncryptionService();
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

}
