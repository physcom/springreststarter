package com.example.demo.mapper.user.impl;

import com.example.demo.dto.auth.AuthenticatedUserDto;
import com.example.demo.dto.security.RoleShortDto;
import com.example.demo.dto.user.UserShortDto;
import com.example.demo.mapper.role.RoleMapper;
import com.example.demo.mapper.user.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapperImpl implements UserMapper {

    private final RoleMapper roleMapper;

    public UserMapperImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public AuthenticatedUserDto toAuthenticatedUserDto(User user, String token) {
        AuthenticatedUserDto authenticatedUserDto = new AuthenticatedUserDto();

        List<RoleShortDto> roles = user.getRoles()
                .stream()
                .map(roleMapper::toRoleShortDto)
                .collect(Collectors.toList());
        UserShortDto userSimplifiedDto = toUserShortDto(user);

        authenticatedUserDto.setRoles(roles);
        authenticatedUserDto.setUser(userSimplifiedDto);
        authenticatedUserDto.setToken(token);
        return authenticatedUserDto;
    }

    private UserShortDto toUserShortDto(User user) {
        UserShortDto userSimplifiedDto = new UserShortDto();
        userSimplifiedDto.setId(user.getId());
        userSimplifiedDto.setEmail(user.getEmail());
        userSimplifiedDto.setLastName(user.getLastName());
        userSimplifiedDto.setFirstName(user.getFirstName());
        userSimplifiedDto.setUsername(user.getUsername());
        return userSimplifiedDto;
    }
}
