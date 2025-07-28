package com.microservice.user.dto.user;

import com.microservice.user.model.User;

import java.util.UUID;

public record UserResponseDTO(
        UUID userId,
        String name,
        String email
) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(
            user.getUserId(),
            user.getName(),
            user.getEmail()
        );
    }
}
