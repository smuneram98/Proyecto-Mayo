package com.mayo.notas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mayo.notas.model.User;
import com.mayo.notas.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> crear(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<User>> findByUsername(@PathVariable String name){
        return ResponseEntity.ok(userService.findByName(name));
    }
}
