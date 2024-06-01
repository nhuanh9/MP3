package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findAllByNameContaining(String name);
    List<Album> findAlbumByOrderByLikesDesc();
    List<Album> findAlbumByOrderByListensDesc();
    List<Album> findTop5ByOrderByLikesDesc();
    List<Album> findTop5ByOrderByListensDesc();
    List<Album>findAlbumByUserId(Long id);
}
