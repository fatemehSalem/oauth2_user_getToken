package com.university.javaeeproject.service;

import com.university.javaeeproject.dto.UserDto;
import com.university.javaeeproject.entity.Role;
import com.university.javaeeproject.entity.User;
import com.university.javaeeproject.mapper.UserMapper;
import com.university.javaeeproject.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService , UserDetailsService {

    private UserMapper userMapper;
    private RoleService roleService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserMapper userMapper, RoleService roleService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("No user found with username " + username));
//        Set grantedAuthorities = getAuthorities(user.get());
//        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), grantedAuthorities);
        return user.get();
    }
//    private Set getAuthorities(User user) {
//        Set<Role> roleByUserId = user.getRoles();
//        Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
//        final Set authorities = roleByUserId.stream().map(role -> new SimpleGrantedAuthority( role.toString().toUpperCase())).collect(Collectors.toSet());
//        return authorities;
//    }

    @Override
    public List<User> findAll() {
        List users = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(user -> users.add(user));
        return users;
    }
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public UserDto save(UserDto userDto) {
        Optional<User> userWithDuplicateUsername = userRepository.findByUsername(userDto.getUsername());
        if(userWithDuplicateUsername.isPresent()) {
            throw new RuntimeException("Duplicate username.");
        }
        Optional<User> userWithDuplicateEmail = userRepository.findUserByEmail(userDto.getEmail());
        if(userWithDuplicateEmail.isPresent()) {
            throw new RuntimeException("Duplicate email.");
        }

        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        userDto.setId(savedUser.getId());
        userDto.setRoles(user.getRoles());
        return userDto;
    }

    @Override
    public Optional<User> findUserByEmail(String userEmail) {
        return userRepository.findUserByEmail(userEmail);
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }
}
