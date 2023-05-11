package com.example.standerDemoBasic.service;

import com.example.standerDemoBasic.model.User;
import com.example.standerDemoBasic.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser =userRepo.findByEmail(username);
        if (optionalUser.isEmpty()){
            throw new UsernameNotFoundException("username not found !!");
        }
        return optionalUser.get();
    }
}
