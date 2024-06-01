package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.SongPlayList;
import com.example.jwtspring3.repository.SongPlaylistRepository;
import com.example.jwtspring3.service.ISongPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongPlaylistServiceImpl implements ISongPlaylistService {
    @Autowired
    SongPlaylistRepository songPlaylistRepository;
    @Override
    public Iterable<SongPlayList> findAll() {
        return songPlaylistRepository.findAll();
    }

    @Override
    public SongPlayList save(SongPlayList songPlayList) {
        return songPlaylistRepository.save(songPlayList);
    }

    @Override
    public Optional<SongPlayList> findById(Long id) {
        return songPlaylistRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        songPlaylistRepository.deleteById(id);
    }

    @Override
    public Object findAllByPlayListId(Long id) {
        List<SongPlayList> list = songPlaylistRepository.findAllByPlayListId(id);
        return  list;
    }

    @Override
    public Iterable<SongPlayList> findAllBySongId(Long id) {
        return songPlaylistRepository.findAllBySongId(id);
    }

    @Override
    public void removeAllBySongId(Iterable<SongPlayList> songPlayLists) {
        songPlaylistRepository.deleteAll(songPlayLists);
    }
}
