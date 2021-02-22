package io.qtechdigital.onlineTutoring.mapper.role.impl;

import io.qtechdigital.onlineTutoring.mapper.role.RoleMapper;
import io.qtechdigital.onlineTutoring.dto.security.RoleShortDto;
import io.qtechdigital.onlineTutoring.model.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleMapperImpl implements RoleMapper {
    @Override
    public RoleShortDto toRoleShortDto(Role role) {
        return new RoleShortDto().setCode(role.getCode());
    }
}
