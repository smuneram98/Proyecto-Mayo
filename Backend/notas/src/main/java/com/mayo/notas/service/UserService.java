package com.mayo.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mayo.notas.model.User;
import com.mayo.notas.repository.UserRepository;

@Service
//@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findByName(String name){
        return userRepository.findByUsername(name);
    }

    
}
