package com.pariuteam.tetriaBack.config.encryption;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.pariuteam.tetriaBack.api.dto.EncryptedId;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class EncryptedIdDeserializer extends JsonDeserializer<EncryptedId> {
    private final EncryptionUseCases encryptionUseCases;

    public EncryptedIdDeserializer(){
        this.encryptionUseCases = EncryptionServiceFactory.getEncryptionUseCasesImplementation();
    }

    @Override
    public EncryptedId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return EncryptedId.of(encryptionUseCases.decryptId(jsonParser.getValueAsString()));
    }
}
