package io.qtechdigital.onlineTutoring.service.authentication.impl;

import io.qtechdigital.onlineTutoring.service.authentication.AuthenticationService;
import io.qtechdigital.onlineTutoring.dto.auth.AuthenticationRequestDto;
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
    public Authentication authenticate(AuthenticationRequestDto requestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword().trim()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }
}
