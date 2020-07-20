package com.example.demo.dto.auth;

import com.example.demo.dto.security.RoleShortDto;
import com.example.demo.dto.user.UserShortDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthenticatedUserDto {
    private UserShortDto user;
    private String token;
    private List<RoleShortDto> roles;
}
