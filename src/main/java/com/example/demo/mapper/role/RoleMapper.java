package com.example.demo.mapper.role;

import com.example.demo.dto.security.RoleShortDto;
import com.example.demo.model.Role;

public interface RoleMapper {
    RoleShortDto toRoleShortDto(Role role);
}
