package com.pariuteam.tetriaBack.config.encryption;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.pariuteam.tetriaBack.api.dto.EncryptedId;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class EncryptedIdSerializer extends JsonSerializer<EncryptedId> {
    private EncryptionUseCases encryptionUseCases;

    public EncryptedIdSerializer(){
        this.encryptionUseCases = EncryptionServiceFactory.getEncryptionUseCasesImplementation();
    }

    @Override
    public void serialize(EncryptedId encryptedId, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(encryptionUseCases.encryptId(encryptedId.value()));
    }
}
