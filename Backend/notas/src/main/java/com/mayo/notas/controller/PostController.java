package com.mayo.notas.controller;

import java.util.List;

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
    public Post crear(@RequestBody Post post){
        return postService.save(post);
    }

    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public List<Post> findByUsuarioId(@PathVariable Long id){
        return postService.findByUsuarioId(id);
    }
 
}
