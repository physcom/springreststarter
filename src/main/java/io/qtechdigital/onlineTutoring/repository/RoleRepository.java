package io.qtechdigital.onlineTutoring.repository;

import io.qtechdigital.onlineTutoring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByCode(String code);
    List<Role> findAllByIdIn(List<Long> ids);
    Boolean existsByCode(String code);
}
