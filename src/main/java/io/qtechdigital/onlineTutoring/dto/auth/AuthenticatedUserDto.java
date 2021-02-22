package io.qtechdigital.onlineTutoring.dto.auth;

import io.qtechdigital.onlineTutoring.dto.security.RoleShortDto;
import io.qtechdigital.onlineTutoring.dto.user.response.UserShortDto;
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
