package com.mayo.notas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mayo.notas.model.Post;
import com.mayo.notas.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    
    @PostMapping("/crear")
    public ResponseEntity<Post> crear(@RequestBody Post post){
        return ResponseEntity.ok(postService.save(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Post>> findByUsuarioId(@PathVariable Long id){
        return ResponseEntity.ok(postService.findByUsuarioId(id));
    }
 
}
