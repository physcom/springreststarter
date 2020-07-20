package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByCode(String code);
    List<Role> findAllByIdIn(List<Long> ids);
    Boolean existsByCode(String code);
}
