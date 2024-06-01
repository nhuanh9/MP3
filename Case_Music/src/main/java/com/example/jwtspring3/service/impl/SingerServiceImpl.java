package com.example.jwtspring3.service.impl;

import com.example.jwtspring3.model.Singer;
import com.example.jwtspring3.repository.SingerRepository;
import com.example.jwtspring3.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SingerServiceImpl implements ISingerService {
    @Autowired
    SingerRepository singerRepository;
    @Override
    public Iterable<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {
        singerRepository.deleteById(id);
    }

    @Override
    public List<Singer> findByNameContaining(String name) {
        return singerRepository.findAllByNameContaining(name);
    }

    @Override
    public List<Singer> findAllByAuthorId(Long id) {
        return singerRepository.findAllByAuthorId(id);
    }

    @Override
    public Singer getOneSinger(Long id) {
        return singerRepository.findSingerById(id);
    }
}
