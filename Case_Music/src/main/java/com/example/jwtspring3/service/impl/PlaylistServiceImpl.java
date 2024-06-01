package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.PlayList;
import com.example.jwtspring3.repository.PlaylistRepository;
import com.example.jwtspring3.service.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PlaylistServiceImpl implements IPlaylistService {
   @Autowired
    PlaylistRepository playlistRepository;
    @Override
    public Iterable<PlayList> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public PlayList save(PlayList playList) {
        return playlistRepository.save(playList);
    }

    @Override
    public Optional<PlayList> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public Object findAllByUserId(Long id) {
        return playlistRepository.findAllByUserId(id);
    }
}
