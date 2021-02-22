package io.qtechdigital.onlineTutoring.repository;

import io.qtechdigital.onlineTutoring.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles"})
    User findByUsername(String name);

    Boolean  existsByUsername(String username);

    Boolean existsByEmail(String email);
}
