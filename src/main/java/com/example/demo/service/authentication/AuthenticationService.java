package com.example.demo.service.authentication;

import com.example.demo.dto.AuthenticationRequestDto;

public interface AuthenticationService {
    void authenticate(AuthenticationRequestDto requestDto);
}
