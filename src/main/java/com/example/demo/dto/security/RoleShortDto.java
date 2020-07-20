package com.example.demo.dto.security;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class RoleShortDto {
    private String code;
}
