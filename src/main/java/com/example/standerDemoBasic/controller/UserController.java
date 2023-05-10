package com.example.standerDemoBasic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from user controller");
    }

    @GetMapping("say/bye")
    public ResponseEntity<String> sayBye(){
        return ResponseEntity.ok("bye form user controller");
    }
}
