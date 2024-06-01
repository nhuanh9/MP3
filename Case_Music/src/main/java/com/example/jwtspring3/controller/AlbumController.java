package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Album;
import com.example.jwtspring3.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/albums")
public class AlbumController {
    @Autowired
    IAlbumService albumService;
    @GetMapping
    public ResponseEntity showAll(String name){
        return new ResponseEntity<>(albumService.findAll(name), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Album album){
        return new ResponseEntity<>(albumService.save(album), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody Album album, @PathVariable Long id){
        album.setId(id);
        return new ResponseEntity<>(albumService.save(album), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        albumService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/sort-by-likes")
    public ResponseEntity sortByLikeDesc(){
        return new ResponseEntity<>(albumService.findAlbumByOrderByLikesDesc(), HttpStatus.OK);
    }
    @GetMapping("/sort-by-listens")
    public ResponseEntity sortByListensDesc(){
        return new ResponseEntity<>(albumService.findAlbumByOrderByListensDesc(), HttpStatus.OK);
    }
    @GetMapping("/top-by-likes")
    public ResponseEntity findTop5ByLikes(){
        return new ResponseEntity<>(albumService.findTop5ByOrderByLikesDesc(), HttpStatus.OK);
    }
    @GetMapping("/top-by-listens")
    public ResponseEntity findTop5Listens(){
        return new ResponseEntity<>(albumService.findTop5ByOrderByListensDesc(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findAlbumByUserId(@PathVariable Long id){
        return new ResponseEntity<>(albumService.findAlbumByUserId(id), HttpStatus.OK);
    }
}
