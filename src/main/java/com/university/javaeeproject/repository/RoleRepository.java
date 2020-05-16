package com.university.javaeeproject.repository;

import com.university.javaeeproject.entity.Role;
import com.university.javaeeproject.util.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleById(Long roleId);

    Set<Role> findByRoleName(RoleType roleName);
}
