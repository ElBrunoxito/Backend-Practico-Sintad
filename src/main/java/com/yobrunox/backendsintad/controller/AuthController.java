package com.yobrunox.backendsintad.controller;

import com.yobrunox.backendsintad.dto.auth.LoginRequest;
import com.yobrunox.backendsintad.dto.exception.ErrorAndResponseDTO;
import com.yobrunox.backendsintad.service.EntityService;
import com.yobrunox.backendsintad.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {


    private final UserService userService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        var token =  userService.login(loginRequest);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .code("R-200")
                .body(token)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody LoginRequest registerRequest) {

        userService.register(registerRequest);
        ErrorAndResponseDTO response = ErrorAndResponseDTO.builder()
                .message("Usuario registrado correctamente")
                .code("R-200")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
