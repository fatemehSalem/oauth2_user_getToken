package com.university.javaeeproject.repository;

import com.university.javaeeproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String userName);

    Optional<User> findUserByEmail(String userEmail);

    Optional<User> findUserById(Long userId);

    List<User> findAll();

    void deleteById(Long userId);


}
