package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllByNameContaining(String name);
    List<Song> findAllByAlbumId(Long id);

    List<Song> findAllByAlbum_NameContaining(String albumName);

    List<Song> findAllBySinger_NameContaining(String singerName);

    List<Song> findAllByNameContainingAndAlbum_NameContaining(String name, String albumName);

    List<Song> findAllByNameContainingAndSinger_NameContaining(String name, String singerName);

    List<Song> findAllByAlbum_NameContainingAndSinger_NameContaining(String albumName, String singerName);

    List<Song> findAllByNameContainingAndAlbum_NameContainingAndSinger_NameContaining(String name, String albumName, String singerName);
    List<Song> findAllByAuthorId (Long id);
    @Query("SELECT s FROM Song s ORDER BY s.listens DESC limit 10")
    List<Song> findTop10ByListens();
    Song findSongById(Long id);

    List<Song> findTop5ByOrderByTimeDesc();
    @Query("SELECT s FROM Song s WHERE s.name LIKE %:search% OR s.singer.name LIKE %:search% OR s.category.name LIKE %:search% or s.album.name LIKE %:search%")
    List<Song> searchSongs( String search);
}
