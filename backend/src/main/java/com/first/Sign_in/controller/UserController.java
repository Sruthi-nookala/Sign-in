package com.first.Sign_in.controller;

import com.first.Sign_in.model.User;
import com.first.Sign_in.repository.UserRepository;
import com.first.Sign_in.service.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="http://localhost:3000/")
public class UserController {

    // Constructor Injection
    public UserController(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    private final UserRepository userRepository;


    private final EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userRepository.save(user);
        String emailBody = "New user registered: " + user.getName() + "(" + user.getEmail() + ")";
        emailService.sendEmail("srushiny@gmail.com", "New Registration", emailBody);
        return ResponseEntity.ok("User registered successfully!");
    }
}
