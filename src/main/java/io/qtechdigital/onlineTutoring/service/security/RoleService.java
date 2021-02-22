package io.qtechdigital.onlineTutoring.service.security;

import io.qtechdigital.onlineTutoring.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAll();

    Role findByCode(String code);

    Role findById(Long id);

    boolean existByCode(String code);

    void delete(Long id);
}
