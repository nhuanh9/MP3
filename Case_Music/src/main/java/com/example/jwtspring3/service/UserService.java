package com.example.jwtspring3.service;


import com.example.jwtspring3.model.Role;
import com.example.jwtspring3.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;
import java.util.Set;

public interface UserService extends UserDetailsService {
    void save(User user);

    Iterable<User> findAll();
    Iterable<User> findAllByRolesName(String roleName);
    Iterable<User> findAllByRolesNameNot();

    User getOneUser(Long id);
    User findByUsername(String username);

    User getCurrentUser();

    Optional<User> findById(Long id);

    UserDetails loadUserById(Long id);

    boolean checkLogin(User user);

    boolean isRegister(User user);

    boolean isCorrectConfirmPassword(User user);
}
