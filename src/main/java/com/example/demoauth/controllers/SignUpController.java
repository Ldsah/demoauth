package com.example.demoauth.controllers;

import com.example.demoauth.model.User;
import com.example.demoauth.pojo.RegistrationForm;
import com.example.demoauth.pojo.MessageResponse;
import com.example.demoauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody RegistrationForm registrationForm){
        if(userRepository.existsByUsername(registrationForm.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already exist"));
        }
        if(userRepository.existsByEmail(registrationForm.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: This email is already in use"));
        }

        User user = new User(registrationForm.getUsername(),
                passwordEncoder.encode(registrationForm.getPassword()),
                registrationForm.getEmail(),
                registrationForm.getName(),
                registrationForm.getPhone(),
                registrationForm.getGender(),
                registrationForm.getAge());

        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User created"));
    }





}
