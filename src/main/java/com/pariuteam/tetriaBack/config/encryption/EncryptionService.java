package com.pariuteam.tetriaBack.config.encryption;

import com.pariuteam.tetriaBack.domain.exceptions.EncryptionException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class EncryptionService implements  EncryptionUseCases{

    private final Cipher encryptCypher;
    private final Cipher decryptCypher;


    public EncryptionService() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        Key key = new SecretKeySpec("16_character_key".getBytes(),"AES");

        if(Security.getProvider(BouncyCastleProvider.PROVIDER_NAME)==null){
            Security.addProvider(new BouncyCastleProvider());
        }

        this.encryptCypher = initCipher(Cipher.ENCRYPT_MODE, key, "AES/ECB/PKCS5Padding");
        this.decryptCypher = initCipher(Cipher.DECRYPT_MODE, key, "AES/ECB/PKCS5Padding");
    }

    private Cipher initCipher(int encryptMode, Key key, String transformation) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        Cipher cipher = Cipher.getInstance(transformation, BouncyCastleProvider.PROVIDER_NAME);
        cipher.init(encryptMode, key);
        return cipher;
    }

    @Override
    public String encryptId(Long plainId){
        try{
            return new String(Hex.encode(encryptCypher.doFinal(plainId.toString().getBytes())));
        }catch(Exception e){
            throw new EncryptionException(EncryptionException.EncryptionOperation.ENCRYPT);
        }
    }

    @Override
    public Long decryptId(String cipher){
        try{
            return Long.valueOf(new String(decryptCypher.doFinal(Hex.decode(cipher))));
        }catch(Exception e){
            throw new EncryptionException(EncryptionException.EncryptionOperation.DECRYPT);
        }
    }
}
