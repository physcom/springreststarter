package com.example.demo.endpoint.authentication;

import com.example.demo.dto.AuthenticationRequestDto;
import com.example.demo.dto.user.UserRegisterDto;
import com.example.demo.dto.auth.AuthenticatedUserDto;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationEndpoint {
    AuthenticatedUserDto authenticate(AuthenticationRequestDto requestDto);
    AuthenticatedUserDto register(UserRegisterDto userRegisterDto);
    AuthenticatedUserDto refreshToken(HttpServletRequest request);
}
