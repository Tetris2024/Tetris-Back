package com.pariuteam.tetriaBack.domain.exceptions;

public class EncryptionException extends CustomException{
    public EncryptionException(EncryptionOperation operation) {
        super("ENCRYPTION_ERROR", "error encountered "+(operation.equals(EncryptionOperation.ENCRYPT)?"encrypting id":"decrypting id"));
    }

    public enum EncryptionOperation{
        ENCRYPT,
        DECRYPT
    }
}
