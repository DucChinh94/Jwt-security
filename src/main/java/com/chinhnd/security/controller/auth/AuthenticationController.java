package com.chinhnd.security.controller.auth;

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

//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationRespone> register(@RequestBody RegisterRequest request) {
//
//    };
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationRespone> register(@RequestBody AuthenticationRequest request) {
//
//    };
}