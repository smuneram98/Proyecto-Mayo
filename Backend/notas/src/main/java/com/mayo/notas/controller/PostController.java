package com.mayo.notas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mayo.notas.model.Post;
import com.mayo.notas.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private PostService postService;
    
    @PostMapping
    public ResponseEntity<Post> crear(@RequestBody Post post){
        return ResponseEntity.ok(postService.save(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Post>> findByUserId(@PathVariable Long id){
        return ResponseEntity.ok(postService.findByUserId(id));
    }
 
}
