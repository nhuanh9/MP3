package com.example.jwtspring3.repository;



import com.example.jwtspring3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Iterable<User> findAllByRolesName(String roleName);
    Iterable<User> findByRolesNameNot(String roleName);
    User findUserById(Long id);
}