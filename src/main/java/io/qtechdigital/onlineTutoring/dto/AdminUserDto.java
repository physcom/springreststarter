package io.qtechdigital.onlineTutoring.dto;

import io.qtechdigital.onlineTutoring.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String status;

    public User toUser() {
        User user = new User(firstName, lastName, email);
        user.setId(id);
        return user;
    }


    public static AdminUserDto fromUser(User user) {

        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setFirstName(user.getFirstName());
        adminUserDto.setLastName(user.getLastName());
        adminUserDto.setEmail(user.getEmail());

        if(user.isEnabled())
            adminUserDto.setStatus("ACTIVE");
        else
            adminUserDto.setStatus("NOT_ACTIVE");

        return adminUserDto;
    }
}
