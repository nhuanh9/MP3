package com.example.jwtspring3.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String confirmPassword;
    private boolean enabled = true;
    private String name;
    @Column(length = 1000)
    private String avatar;
    private String phone;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    public User(String username, String password, String confirmPassword, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.roles = roles;
    }

    public User(Long id, String username, String password, String confirmPassword, boolean enabled, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.enabled = enabled;
        this.roles = roles;
    }

    public User(String username, String password, String confirmPassword, boolean enabled, String name, String avatar, String phone, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.enabled = enabled;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
        this.roles = roles;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
