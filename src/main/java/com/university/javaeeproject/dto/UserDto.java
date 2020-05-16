package com.university.javaeeproject.dto;

import com.university.javaeeproject.entity.Role;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {

    private Long id;
    private Long courseId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Set<Role> roles  = new HashSet<>();

}
