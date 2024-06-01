package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Singer;
import com.example.jwtspring3.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/singers")
public class SingerController {
    @Autowired
    ISingerService singerService;

    @PostMapping
    public ResponseEntity save(@RequestBody Singer singer){
        return new ResponseEntity<>(singerService.save(singer),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id ,@RequestBody Singer singer){
        singer.setId(id);
        return new ResponseEntity<>(singerService.save(singer),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        singerService.remove(id);
        return new ResponseEntity<>("done remove",HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity findAll(){
        return new ResponseEntity(singerService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/author/{id}")
    public ResponseEntity findAllByAuthorId(@PathVariable Long id){
        return new ResponseEntity<>(singerService.findAllByAuthorId(id), HttpStatus.OK);
    }
    @GetMapping("/singer/{id}")
    public ResponseEntity getOneSinger(@PathVariable Long id) {return new ResponseEntity<>(singerService.getOneSinger(id), HttpStatus.OK);}
 }
