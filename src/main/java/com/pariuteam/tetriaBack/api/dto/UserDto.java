package com.pariuteam.tetriaBack.api.dto;

import jakarta.persistence.GeneratedValue;
import lombok.Builder;

@Builder
public record UserDto(String username, Long score) {
}
