package com.example.jwtspring3.model;

import jakarta.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String avatar;
    private Long likes;
    private Long listens;
    @ManyToOne
    private User user;

    public Album(Long id, String name, String avatar, Long likes, Long listens, User user) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.likes = likes;
        this.listens = listens;
        this.user = user;
    }

    public Album() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getListens() {
        return listens;
    }

    public void setListens(Long listens) {
        this.listens = listens;
    }
}
