package com.yobrunox.backendsintad.service;

import com.yobrunox.backendsintad.dto.auth.LoginRequest;
import com.yobrunox.backendsintad.dto.auth.TokenResponse;
import com.yobrunox.backendsintad.dto.exception.BusinessException;
import com.yobrunox.backendsintad.model.ERole;
import com.yobrunox.backendsintad.model.UserEntity;
import com.yobrunox.backendsintad.repository.UserRepository;
import com.yobrunox.backendsintad.security.JwtService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserEntity users = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() ->
                new BusinessException("M-400", HttpStatus.ALREADY_REPORTED,"Usuario no existente")

        );




        String token = jwtService.generateToken(users);

        TokenResponse tokenResponse = TokenResponse.builder()
                .token(token)
                .expiresAt(jwtService.getExpiration(token))
                .username(users.getUsername())
                .build();

        return tokenResponse;
    }

    @Transactional
    public void register(LoginRequest registerRequest){


        UserEntity user = UserEntity.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(ERole.USER)
                .build();
        userRepository.save(user);
    }
}
