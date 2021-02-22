package io.qtechdigital.onlineTutoring.endpoint.authentication;

import io.qtechdigital.onlineTutoring.dto.auth.AuthenticationRequestDto;
import io.qtechdigital.onlineTutoring.dto.user.request.UserRegisterRequest;
import io.qtechdigital.onlineTutoring.dto.auth.AuthenticatedUserDto;

public interface AuthenticationEndpoint {
    AuthenticatedUserDto authenticate(AuthenticationRequestDto requestDto);
    AuthenticatedUserDto register(UserRegisterRequest userRegisterRequest);
}
