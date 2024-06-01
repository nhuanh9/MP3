package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.SongPlayList;
import com.example.jwtspring3.service.ISongPlaylistService;
import com.example.jwtspring3.service.impl.SongPlaylistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/song-playlist")
public class SongPlaylistController {
    @Autowired
    ISongPlaylistService songPlaylistService;
    @GetMapping
    public ResponseEntity showAll(){
        return new ResponseEntity<>(songPlaylistService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody SongPlayList songPlayList){
        return new ResponseEntity<>(songPlaylistService.save(songPlayList), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody SongPlayList songPlayList, @PathVariable Long id){
        songPlayList.setId(id);
        return new ResponseEntity<>(songPlaylistService.save(songPlayList), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        songPlaylistService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity<>(songPlaylistService.findAllByPlayListId(id),HttpStatus.OK);
    }
}
