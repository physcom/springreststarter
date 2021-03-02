package io.qtechdigital.onlineTutoring.dto.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AuthenticationRequestDto {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
