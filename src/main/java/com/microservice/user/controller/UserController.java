package com.microservice.user.controller;

import com.microservice.user.dto.user.UserResponseDTO;
import com.microservice.user.dto.user.UserSaveDTO;
import com.microservice.user.model.User;
import com.microservice.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@RequestBody @Valid UserSaveDTO userSaveDTO) {
        User user = userSaveDTO.toEntity();
        BeanUtils.copyProperties(userSaveDTO, user);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDTO.fromEntity(userService.save(user)));
    }
}
