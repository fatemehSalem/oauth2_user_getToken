package com.university.javaeeproject.mapper;

import com.university.javaeeproject.dto.UserDto;
import com.university.javaeeproject.entity.Role;
import com.university.javaeeproject.entity.User;
import com.university.javaeeproject.service.RoleService;
import com.university.javaeeproject.util.RoleType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

@Service
public class UserMapper extends  Mapper<User, UserDto> {
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public UserMapper(PasswordEncoder passwordEncoder, RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setCourseId(userDto.getCourseId());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(userDto.getRoles());
        Set<Role> optionalRole = userDto.getRoles();
        Set<Role> r = new HashSet<>();
        for (Iterator<Role> it = optionalRole.iterator(); it.hasNext(); ) {
            Role f = it.next();
            RoleType roleName = f.getRoleName();
              r = roleService.findByRoleName(roleName);
        }
         if(r != null && r.size() > 0){
                user.setRoles(r);
            }
        user.setUsername(userDto.getUsername());
        return  user;

    }


    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setCourseId(user.getCourseId());
        //....
        return userDto;
    }
}
