package com.example.standerDemoBasic.controller;

import com.example.standerDemoBasic.DTO.AuthenticaionRequst;
import com.example.standerDemoBasic.config.JwtUtils;
import com.example.standerDemoBasic.model.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthentcaionController {

    private final AuthenticationManager authenticationManager;
    private final MyUser myUser;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticaionRequst authenticaionRequst
    ){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticaionRequst.getEmail(), authenticaionRequst.getPassword())
        );
        final UserDetails user = myUser.findUserByEmail(authenticaionRequst.getEmail());
        if (user != null){
        return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("some error !!");
    }
}
