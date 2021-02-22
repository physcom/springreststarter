package io.qtechdigital.onlineTutoring.mapper.user.impl;

import io.qtechdigital.onlineTutoring.mapper.user.UserMapper;
import io.qtechdigital.onlineTutoring.dto.auth.AuthenticatedUserDto;
import io.qtechdigital.onlineTutoring.dto.security.RoleShortDto;
import io.qtechdigital.onlineTutoring.dto.user.response.UserShortDto;
import io.qtechdigital.onlineTutoring.mapper.role.RoleMapper;
import io.qtechdigital.onlineTutoring.model.User;
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
        userSimplifiedDto.setSsn(user.getSsn());
        return userSimplifiedDto;
    }
}
