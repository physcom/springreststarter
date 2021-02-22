package io.qtechdigital.onlineTutoring.endpoint.authentication.impl;

import io.qtechdigital.onlineTutoring.endpoint.authentication.AuthenticationEndpoint;
import io.qtechdigital.onlineTutoring.exception.AlreadyExistException;
import io.qtechdigital.onlineTutoring.model.Role;
import io.qtechdigital.onlineTutoring.security.jwt.JwtTokenProvider;
import io.qtechdigital.onlineTutoring.dto.auth.AuthenticationRequestDto;
import io.qtechdigital.onlineTutoring.dto.user.request.UserRegisterRequest;
import io.qtechdigital.onlineTutoring.dto.auth.AuthenticatedUserDto;
import io.qtechdigital.onlineTutoring.mapper.user.UserMapper;
import io.qtechdigital.onlineTutoring.model.User;
import io.qtechdigital.onlineTutoring.service.security.RoleService;
import io.qtechdigital.onlineTutoring.service.user.UserService;
import io.qtechdigital.onlineTutoring.service.authentication.AuthenticationService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthenticationEndpointImpl implements AuthenticationEndpoint {

    private final UserService userService;
    private final RoleService roleService;
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;

    public AuthenticationEndpointImpl(UserService userService, RoleService roleService, AuthenticationService authenticationService, JwtTokenProvider jwtTokenProvider, UserMapper userMapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userMapper = userMapper;
    }

    @Override
    public AuthenticatedUserDto authenticate(AuthenticationRequestDto requestDto) {
        authenticationService.authenticate(requestDto);
        User user = userService.findByUsername(requestDto.getUsername().trim());
        String token = jwtTokenProvider.createToken(requestDto.getUsername(), user.getRoles());
        return userMapper.toAuthenticatedUserDto(user, token);
    }

    @Override
    public AuthenticatedUserDto register(UserRegisterRequest userRegisterRequest) {

        if (userService.existByUsername(userRegisterRequest.getUsername())) {
            throw new AlreadyExistException(userRegisterRequest.getUsername());
        }

        Role role = roleService.findByCode(userRegisterRequest.getRoleCode());

        User user = new User(userRegisterRequest.getUsername(), userRegisterRequest.getName(), userRegisterRequest.getSurname(), userRegisterRequest.getEmail());

        user.setPassword(userRegisterRequest.getPassword());
        user.setEnabled(false);
        user.setRoles(Collections.singletonList(role));

        User result = userService.register(user);
        String token = jwtTokenProvider.generateToken(result);

        return userMapper.toAuthenticatedUserDto(user, token);
    }
}
