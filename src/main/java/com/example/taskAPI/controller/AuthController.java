package com.example.taskAPI.controller;

import com.example.taskAPI.model.LoginRequest;
import com.example.taskAPI.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtService jwtService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {


        try {
            //1 auth
            authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));



            //2. skapa token
            String token = jwtService.generateToken(req.getUsername());


            //3. returnerar vi token
            return ResponseEntity.ok(Map.of("token", token));
        } catch ( Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }

}
