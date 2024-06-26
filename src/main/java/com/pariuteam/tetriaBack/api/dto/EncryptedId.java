package com.pariuteam.tetriaBack.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pariuteam.tetriaBack.config.encryption.EncryptedIdDeserializer;
import com.pariuteam.tetriaBack.config.encryption.EncryptedIdSerializer;

@JsonSerialize(using = EncryptedIdSerializer.class)
@JsonDeserialize(using = EncryptedIdDeserializer.class)
public record EncryptedId ( Long value){
    public static EncryptedId of(Long userId) {
        return new EncryptedId(userId);
    }
}
