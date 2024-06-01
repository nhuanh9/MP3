package com.example.jwtspring3.service;

import com.example.jwtspring3.model.Singer;

import java.util.List;

public interface ISingerService extends IGeneralService<Singer> {
    List<Singer> findByNameContaining(String name);
    List<Singer> findAllByAuthorId(Long id);
    Singer getOneSinger(Long id);
}
