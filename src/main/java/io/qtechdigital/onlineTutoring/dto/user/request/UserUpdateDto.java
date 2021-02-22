package io.qtechdigital.onlineTutoring.dto.user.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserUpdateDto {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private List<Long> roleIds;
}
