package com.example.jwtspring3.model;

import jakarta.persistence.*;

@Entity
public class SongPlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private PlayList playList;
    @ManyToOne
    private Song song;

    public SongPlayList(Long id, PlayList playList, Song song) {
        this.id = id;
        this.playList = playList;
        this.song = song;
    }

    public SongPlayList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
