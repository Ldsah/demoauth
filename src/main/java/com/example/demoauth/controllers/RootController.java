package com.example.demoauth.controllers;

import com.example.demoauth.model.User;
import com.example.demoauth.pojo.MessageResponse;
import com.example.demoauth.pojo.RegistrationForm;
import com.example.demoauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class RootController {

    @GetMapping
    public ResponseEntity<?> signUpUser(){
        return ResponseEntity.ok(new MessageResponse("Hello"));
    }





}
