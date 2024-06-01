package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.PlayList;
import com.example.jwtspring3.model.SongPlayList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<PlayList,Long> {
    List<PlayList> findAllByUserId(Long userId);
}
