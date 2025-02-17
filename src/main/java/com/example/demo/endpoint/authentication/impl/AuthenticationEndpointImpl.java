package com.example.demo.endpoint.authentication.impl;

import com.example.demo.dto.AuthenticationRequestDto;
import com.example.demo.dto.user.UserRegisterDto;
import com.example.demo.dto.auth.AuthenticatedUserDto;
import com.example.demo.endpoint.authentication.AuthenticationEndpoint;
import com.example.demo.exception.AlreadyExistException;
import com.example.demo.mapper.user.UserMapper;
import com.example.demo.model.User;
import com.example.demo.security.jwt.JwtUtil;
import com.example.demo.service.UserService;
import com.example.demo.service.authentication.AuthenticationService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthenticationEndpointImpl implements AuthenticationEndpoint {

    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    public AuthenticationEndpointImpl(UserService userService, AuthenticationService authenticationService, JwtUtil jwtUtil, UserMapper userMapper) {
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.jwtUtil = jwtUtil;
        this.userMapper = userMapper;
    }

    @Override
    public AuthenticatedUserDto authenticate(AuthenticationRequestDto requestDto) {
        authenticationService.authenticate(requestDto);
        User user = userService.findByUsername(requestDto.getUsername().trim());

        String token = jwtUtil.createToken(requestDto.getUsername(), user.getRoles());
        return userMapper.toAuthenticatedUserDto(user, token);
    }

    @Override
    public AuthenticatedUserDto register(UserRegisterDto userRegisterDto) {

        if (userService.existByUsername(userRegisterDto.getUsername())) {
            throw new AlreadyExistException(userRegisterDto.getUsername());
        }

        User user = new User(userRegisterDto.getUsername(), userRegisterDto.getName(), userRegisterDto.getUsername(), userRegisterDto.getEmail());

        user.setPassword(userRegisterDto.getPassword());

        User result = userService.register(user);
        String token = jwtUtil.createToken(result.getUsername(), result.getRoles());
        return userMapper.toAuthenticatedUserDto(user, token);
    }

    @Override
    public AuthenticatedUserDto refreshToken(HttpServletRequest request) {
        return null;
    }
}
