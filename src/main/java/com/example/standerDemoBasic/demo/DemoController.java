package com.example.standerDemoBasic.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayHi(){
        return ResponseEntity.ok("hay from secured endpoint");
    }

//    @GetMapping("say/bye")
//    public Map<String,Object> sayBye(@AuthenticationPrincipal UserDetails jwt){
//        return Collections.singletonMap("principal", jwt.getUsername());
//    }
}
