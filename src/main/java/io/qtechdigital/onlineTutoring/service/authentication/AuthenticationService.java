package io.qtechdigital.onlineTutoring.service.authentication;

import io.qtechdigital.onlineTutoring.dto.auth.AuthenticationRequestDto;

public interface AuthenticationService {
    void authenticate(AuthenticationRequestDto requestDto);
}
