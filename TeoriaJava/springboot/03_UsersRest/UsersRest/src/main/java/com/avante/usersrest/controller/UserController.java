/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avante.usersrest.controller;

import com.avante.usersrest.model.User;
import com.avante.usersrest.model.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jprof
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserRepository repo;
    
    @GetMapping
    public List<User> list() {
       return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable int id) {
        return repo.findById(id)
                .map( ResponseEntity::ok )
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> post(@RequestBody User u) {
        User new_user = repo.save(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(new_user);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> put(@PathVariable int id, @RequestBody User new_user) {
        return repo.findById(id)
                .map( u -> {
                    u.setEmail(new_user.getEmail());
                    u.setPasswordHash(new_user.getPasswordHash());
                    u.setFullName(new_user.getFullName());
                    
                    return ResponseEntity.ok(repo.save(u));
                } )
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
