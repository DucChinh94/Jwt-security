package com.chinhnd.security.service.auth;

import com.chinhnd.security.dto.request.auth.AuthenticationRequest;
import com.chinhnd.security.dto.request.auth.RegisterRequest;
import com.chinhnd.security.dto.response.ApiResponse;

public interface AuthenticationService {
    ApiResponse register(RegisterRequest request);

    ApiResponse authenticate(AuthenticationRequest request);
}
