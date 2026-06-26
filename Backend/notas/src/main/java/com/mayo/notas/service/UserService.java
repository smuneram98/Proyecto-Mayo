package com.mayo.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.mayo.notas.dto.LoginRequest;
import com.mayo.notas.exception.ResourceNotFoundException;
import com.mayo.notas.model.User;
import com.mayo.notas.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

  /*   public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    } */

    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findByName(String name){
        return userRepository.findByUsername(name);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User update(Long id, User userDetails){
         User user=userRepository.findById(id)
        //.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado"));
        //Se puede así tambíen
        .orElseThrow(()->new RuntimeException("Usuario no encontrado"));
        if(userDetails.getUsername()!=null && !userDetails.getUsername().trim().isEmpty()){
            user.setUsername(userDetails.getUsername());
        }
        if(userDetails.getPassword()!=null && !userDetails.getPassword().trim().isEmpty()){
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }
        
        return userRepository.save(user);
    }

    public String login(LoginRequest request){
        Optional<User> optionalUser=userRepository.findByUsername(request.getUsername());
        if(optionalUser.isEmpty()){
            throw new ResourceNotFoundException("Usuario no encontrado");
        }
        User user = optionalUser.get();
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new ResourceNotFoundException("Contraseña incorrecta");
        }
        return "Login correcto";
    }
 
}
