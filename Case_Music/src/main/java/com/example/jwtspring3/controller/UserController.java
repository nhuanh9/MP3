package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.JwtResponse;
import com.example.jwtspring3.model.Role;
import com.example.jwtspring3.model.User;
import com.example.jwtspring3.service.RoleService;
import com.example.jwtspring3.service.UserService;
import com.example.jwtspring3.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/admin")
    public ResponseEntity<Iterable<User>> showAllUser() {
        Iterable<User> users = userService.findAllByRolesNameNot();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/admin/users")
    public ResponseEntity<Iterable<User>> showAllUserByAdmin() {
        Iterable<User> users = userService.findAllByRolesName("ROLE_USER");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/admin/authors")
    public ResponseEntity<Iterable<User>> showAllAuthorByAdmin() {
        Iterable<User> users = userService.findAllByRolesName("ROLE_AUTHOR");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register/{id}")
    public ResponseEntity createUser(@RequestBody User user, BindingResult bindingResult , @PathVariable Long id) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Iterable<User> users = userService.findAll();
        for (User currentUser : users) {
            if (currentUser.getUsername().equals(user.getUsername())) {
                return new ResponseEntity<>("Username existed",HttpStatus.BAD_REQUEST);
            }
        }
        if (!userService.isCorrectConfirmPassword(user)) {
            return new ResponseEntity<>("Input confirm password",HttpStatus.OK);
        }
        if (user.getRoles() == null ){
            Role role = roleService.findById(id);
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity("Hello World", HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getProfile(@PathVariable Long id) {
        Optional<User> userOptional = this.userService.findById(id);
        return userOptional.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserProfile(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = this.userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(userOptional.get().getId());
        user.setUsername(userOptional.get().getUsername());
        user.setEnabled(userOptional.get().isEnabled());
        user.setPassword(userOptional.get().getPassword());
        user.setRoles(userOptional.get().getRoles());
        user.setConfirmPassword(userOptional.get().getConfirmPassword());
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping("/admin/{id}")
    public ResponseEntity updateEnabled(@PathVariable Long id, @RequestBody User user){
        user = userService.getOneUser(id);
        user.setEnabled(!user.isEnabled());
        userService.save(user);
        return new ResponseEntity<>("Update Success", HttpStatus.OK);
    }
}
