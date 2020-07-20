package com.example.demo.controller.api.v1;

import com.example.demo.dto.AuthenticationRequestDto;
import com.example.demo.dto.user.UserRegisterDto;
import com.example.demo.dto.auth.AuthenticatedUserDto;
import com.example.demo.endpoint.authentication.AuthenticationEndpoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * REST controller for authentication requests (login, logout, register, etc.)
 */

@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestController {

    private final AuthenticationEndpoint authenticationEndpoint;

    public AuthenticationRestController(AuthenticationEndpoint authenticationEndpoint) {
        this.authenticationEndpoint = authenticationEndpoint;
    }

    @PostMapping("login")
    public AuthenticatedUserDto login(@RequestBody AuthenticationRequestDto requestDto, HttpServletRequest request) {
        return authenticationEndpoint.authenticate(requestDto);
    }

    @PostMapping("register")
    public AuthenticatedUserDto register(@RequestBody UserRegisterDto userRegisterDto) {
        return authenticationEndpoint.register(userRegisterDto);
    }
}
