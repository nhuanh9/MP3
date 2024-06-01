package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {
    List<Singer> findAllByNameContaining(String name);
    List<Singer> findAllByAuthorId(Long id);
    Singer findSingerById(Long id);
}
