package io.qtechdigital.onlineTutoring.dto.user;

import io.qtechdigital.onlineTutoring.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.qtechdigital.onlineTutoring.model.enums.AuthProvider;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private AuthProvider authProvider;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return user;
    }

    public static UserDto fromUser(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setAuthProvider(user.getProvider());

        return userDto;
    }
}
