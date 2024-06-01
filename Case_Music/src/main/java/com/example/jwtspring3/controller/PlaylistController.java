package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.PlayList;
import com.example.jwtspring3.service.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/playLists")
public class PlaylistController {
    @Autowired
    IPlaylistService playlistService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity<>(playlistService.findAll(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity save(@RequestBody PlayList playList) {
        return new ResponseEntity<>(playlistService.save(playList), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id, @RequestBody PlayList playList) {
        playList.setId(id);
        return new ResponseEntity<>(playlistService.save(playList), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        PlayList playList = playlistService.findById(id).get();
        playList.setStatus("Deleted");
        playlistService.save(playList);
        return new ResponseEntity("done delete", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findAllByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(playlistService.findAllByUserId(id),HttpStatus.OK);
    }
}
