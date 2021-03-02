package io.qtechdigital.onlineTutoring.service.authentication;

import io.qtechdigital.onlineTutoring.dto.auth.AuthenticationRequestDto;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    Authentication authenticate(AuthenticationRequestDto requestDto);
}
