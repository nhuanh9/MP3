package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Category;
import com.example.jwtspring3.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByNameContaining(String name);
}
