package com.example.demo.mapper.role.impl;

import com.example.demo.dto.security.RoleShortDto;
import com.example.demo.mapper.role.RoleMapper;
import com.example.demo.model.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleShortDto toRoleShortDto(Role role) {
        return new RoleShortDto().setCode(role.getCode());
    }
}
