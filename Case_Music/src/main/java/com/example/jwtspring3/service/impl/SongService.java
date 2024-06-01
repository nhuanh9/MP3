package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Song;
import com.example.jwtspring3.model.SongPlayList;
import com.example.jwtspring3.repository.SongPlaylistRepository;
import com.example.jwtspring3.repository.SongRepository;
import com.example.jwtspring3.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    SongRepository songRepository;
    @Autowired
    SongPlaylistServiceImpl songPlaylistService;
    @Autowired
    SongPlaylistRepository songPlaylistRepository;
    private Map<Long, Boolean> likeStatus = new HashMap<>();

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        Iterable<SongPlayList> songPlayList = songPlaylistService.findAllBySongId(id);
        songPlaylistService.removeAllBySongId(songPlayList);
        songRepository.deleteById(id);
    }

    public List<Song> findAll(String name, String albumName, String singerName) {
        if (name != null && singerName != null && albumName != null) {
            return songRepository.findAllByNameContainingAndAlbum_NameContainingAndSinger_NameContaining(name, albumName, singerName);
        } else if (name != null && singerName != null) {
            return songRepository.findAllByNameContainingAndSinger_NameContaining(name, singerName);
        } else if (name != null && albumName != null) {
            return songRepository.findAllByNameContainingAndAlbum_NameContaining(name, albumName);
        } else if (singerName != null && albumName != null) {
            return songRepository.findAllByAlbum_NameContainingAndSinger_NameContaining(albumName, singerName);
        } else if (name != null) {
            return songRepository.findAllByNameContaining(name);
        } else if (singerName != null) {
            return songRepository.findAllBySinger_NameContaining(singerName);
        } else if (albumName != null) {
            return songRepository.findAllByAlbum_NameContaining(albumName);
        } else {
            return songRepository.findAll();
        }
    }

    @Override
    public Song setLike(Long id) {
        Optional<Song> songOpt = songRepository.findById(id);
        if (!songOpt.isPresent()) {
            return null;
        }
        Song song = songOpt.get();
        boolean isLiked = likeStatus.getOrDefault(id, false);
        if (isLiked) {
            song.setLikes(song.getLikes() - 1);
        } else {
            song.setLikes(song.getLikes() + 1);
        }
        likeStatus.put(id, !isLiked);
        songRepository.save(song);
        return song;
    }

    @Override
    public Song setListen(Long id) {
        Optional<Song> songOpt = songRepository.findById(id);
        songOpt.get().setListens(songOpt.get().getListens()+1);
        songRepository.save(songOpt.get());
        return songOpt.get();
    }

    @Override
    public List<Song> findAllByAuthorId(Long id) {
        return songRepository.findAllByAuthorId(id);
    }

    @Override
    public Song getOneSong(Long id) {
        return songRepository.findSongById(id);
    }

    @Override
    public List<Song> search(String search) {
        return songRepository.searchSongs(search);
    }

    @Override
    public Object findTop10ByListens() {
        return songRepository.findTop10ByListens();
    }

    public List<Song> findAllByAlbumId(Long id) {
        return songRepository.findAllByAlbumId(id);
    }
}
