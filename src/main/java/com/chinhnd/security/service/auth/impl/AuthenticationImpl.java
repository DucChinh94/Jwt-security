package com.chinhnd.security.service.auth.impl;

import com.chinhnd.security.config.auth.JwtService;
import com.chinhnd.security.dto.request.auth.AuthenticationRequest;
import com.chinhnd.security.dto.request.auth.RegisterRequest;
import com.chinhnd.security.dto.response.ApiResponse;
import com.chinhnd.security.dto.response.auth.AuthenticationResponse;
import com.chinhnd.security.entity.auth.Role;
import com.chinhnd.security.entity.auth.User;
import com.chinhnd.security.exception.RecordNotFoundException;
import com.chinhnd.security.repository.UserRepository;
import com.chinhnd.security.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public ApiResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
        return ApiResponse.ApiResponseSuccess(authenticationResponse);
    }

    @Override
    public ApiResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RecordNotFoundException("User not found"));
        String jwtToken = jwtService.generateToken(user);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
        return ApiResponse.ApiResponseSuccess(authenticationResponse);
    }
}
