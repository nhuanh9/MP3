package com.example.jwtspring3.service;

import com.example.jwtspring3.model.PlayList;

public interface IPlaylistService extends IGeneralService<PlayList>{
    Object findAllByUserId(Long id);
}
