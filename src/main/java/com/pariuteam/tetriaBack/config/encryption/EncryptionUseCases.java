package com.pariuteam.tetriaBack.config.encryption;

public interface EncryptionUseCases {
    String encryptId(Long plainId);
    Long decryptId(String cipher);
}
