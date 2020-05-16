package com.university.javaeeproject.controller;

import com.university.javaeeproject.dto.UserDto;
import com.university.javaeeproject.mapper.UserMapper;
import com.university.javaeeproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserControllerTest {

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_TEACHER = "ROLE_TEACHER";
    public static final String ROLE_STUDENT = "ROLE_STUDENT";

    private UserService userService;
    private UserMapper userMapper;

    public UserControllerTest(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/listUser")
    public ResponseEntity listUser(){
      //  log.info(String.format("received request to list user %s", SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findAll());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/createUser")
    public ResponseEntity create(@RequestBody UserDto userDto){
       // log.info(String.format("received request to create user %s", SecurityContextHolder.getContext().getAuthentication().getPrincipal()));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.save(userDto));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/getUser/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
       // log.info(String.format("received request to getUser user %s", SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findUserById(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/deleteUser/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        userService.deleteById(id);
      //  log.info(String.format("received request to delete user %s", SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }



}