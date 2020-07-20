package com.example.demo.mapper.user;

import com.example.demo.dto.auth.AuthenticatedUserDto;
import com.example.demo.model.User;

public interface UserMapper {
    AuthenticatedUserDto toAuthenticatedUserDto(User user, String token);
}
