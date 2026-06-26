package com.mayo.notas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mayo.notas.dto.LoginRequest;
import com.mayo.notas.model.User;
import com.mayo.notas.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @PostMapping("/crear")
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

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.update(id,userDetails);      
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        String response= userService.login(request);
        return ResponseEntity.ok(response);
    }
}
