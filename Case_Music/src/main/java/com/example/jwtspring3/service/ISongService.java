package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService extends IGeneralService<Song>{
    Object findAll(String name, String albumName, String singerName);
    Song setLike(Long id);
    Song setListen(Long id);
    List<Song> findAllByAuthorId(Long id);
    Object findTop10ByListens();
    Song getOneSong(Long id);
    List<Song>search(String search);

    List<Song> findAllByAlbumId(Long id);

}
