package com.university.javaeeproject.service;

import com.university.javaeeproject.dto.UserDto;
import com.university.javaeeproject.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

      Optional<User> findUserByEmail(String userEmail);

      Optional<User> findUserById(Long userId);

      List<User> findAll();

      void deleteById(Long userId);

      UserDto save (UserDto userDto);
}
