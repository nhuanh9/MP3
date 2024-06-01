package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Album;

import java.util.List;

public interface IAlbumService extends IGeneralService<Album>{
    Iterable<Album> findAll(String name);
    List<Album> findAlbumByOrderByLikesDesc();
    List<Album> findAlbumByOrderByListensDesc();
    List<Album> findTop5ByOrderByLikesDesc();
    List<Album> findTop5ByOrderByListensDesc();
    List<Album>findAlbumByUserId(Long id);
}
