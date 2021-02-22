package io.qtechdigital.onlineTutoring.mapper.role;

import io.qtechdigital.onlineTutoring.dto.security.RoleShortDto;
import io.qtechdigital.onlineTutoring.model.Role;

public interface RoleMapper {
    RoleShortDto toRoleShortDto(Role role);
}
