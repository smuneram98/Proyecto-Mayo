package com.mayo.notas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayo.notas.exception.ResourceNotFoundException;
import com.mayo.notas.model.Post;
import com.mayo.notas.model.User;
import com.mayo.notas.repository.PostRepository;
import com.mayo.notas.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post save(Post post){

        Long userId=post.getUsuario().getId();

        User user=userRepository.findById(userId)
             .orElseThrow(()->new ResourceNotFoundException("No existe el usuario"));

        post.setUsuario(user);

        return postRepository.save(post);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public List<Post> findByUsuarioId(Long userId){
        return postRepository.findByUsuarioId(userId);
    }

    
}
