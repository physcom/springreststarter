package io.qtechdigital.onlineTutoring.mapper.user;

import io.qtechdigital.onlineTutoring.dto.auth.AuthenticatedUserDto;
import io.qtechdigital.onlineTutoring.model.User;

public interface UserMapper {
    AuthenticatedUserDto toAuthenticatedUserDto(User user, String token);
}
