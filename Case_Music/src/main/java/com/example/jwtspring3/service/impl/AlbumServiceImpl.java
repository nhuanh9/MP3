package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Album;
import com.example.jwtspring3.repository.AlbumRepository;
import com.example.jwtspring3.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AlbumServiceImpl implements IAlbumService {
    @Autowired
    AlbumRepository albumRepository;
    @Override
    public Iterable<Album> findAll(String name) {
        if (name != null){
            return albumRepository.findAllByNameContaining(name);
        }
        return albumRepository.findAll();
    }

    @Override
    public Iterable<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public List<Album> findAlbumByOrderByLikesDesc() {
        return albumRepository.findAlbumByOrderByLikesDesc();
    }

    @Override
    public List<Album> findAlbumByOrderByListensDesc() {
        return albumRepository.findAlbumByOrderByLikesDesc();
    }

    @Override
    public List<Album> findTop5ByOrderByLikesDesc() {
        return albumRepository.findTop5ByOrderByLikesDesc();
    }

    @Override
    public List<Album> findTop5ByOrderByListensDesc() {
        return albumRepository.findTop5ByOrderByListensDesc();
    }

    @Override
    public List<Album> findAlbumByUserId(Long id) {
        return albumRepository.findAlbumByUserId(id);
    }
}
