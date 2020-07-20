package com.example.demo.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserShortDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String pin;
}
