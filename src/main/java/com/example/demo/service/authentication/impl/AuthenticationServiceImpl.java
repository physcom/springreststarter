package com.example.demo.service.authentication.impl;

import com.example.demo.dto.AuthenticationRequestDto;
import com.example.demo.service.authentication.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void authenticate(AuthenticationRequestDto requestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword().trim()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
