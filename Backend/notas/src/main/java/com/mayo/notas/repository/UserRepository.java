package com.mayo.notas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayo.notas.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);
}
