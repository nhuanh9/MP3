package com.example.jwtspring3.service;

import com.example.jwtspring3.model.SongPlayList;

import java.util.Optional;

public interface ISongPlaylistService extends IGeneralService<SongPlayList>{
    Object findAllByPlayListId(Long id);
    Iterable<SongPlayList> findAllBySongId(Long id);
    void removeAllBySongId(Iterable<SongPlayList> songPlayLists);
}
