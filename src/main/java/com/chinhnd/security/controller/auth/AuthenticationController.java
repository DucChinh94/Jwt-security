package com.chinhnd.security.controller.auth;

import com.chinhnd.security.dto.request.auth.AuthenticationRequest;
import com.chinhnd.security.dto.request.auth.RegisterRequest;
import com.chinhnd.security.dto.response.ApiResponse;
import com.chinhnd.security.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok().body(authenticationService.register(request));
    };

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok().body(authenticationService.authenticate(request));
    };
}
