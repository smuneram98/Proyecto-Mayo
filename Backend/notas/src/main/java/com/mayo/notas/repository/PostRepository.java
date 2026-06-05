package com.mayo.notas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayo.notas.model.Post;
import java.util.List;


public interface PostRepository extends JpaRepository<Post,Long>{
    Optional<Post> findById(Long id);

    List<Post> findByUserId(Long userId);
}
