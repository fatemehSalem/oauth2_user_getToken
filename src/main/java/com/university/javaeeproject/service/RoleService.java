package com.university.javaeeproject.service;

import com.university.javaeeproject.entity.Role;
import com.university.javaeeproject.repository.RoleRepository;
import com.university.javaeeproject.util.RoleType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findRoleById(Long roleId){
        return  roleRepository.findRoleById(roleId);
    }

    public  Set<Role> findByRoleName(RoleType roleName){
        return  roleRepository.findByRoleName(roleName);
    }
}
