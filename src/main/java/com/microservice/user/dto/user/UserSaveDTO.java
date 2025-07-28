package com.microservice.user.dto.user;

import com.microservice.user.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserSaveDTO(
        @NotBlank String name,
        @NotBlank @Email String email
) {
    public User toEntity() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        return user;
    }
}
