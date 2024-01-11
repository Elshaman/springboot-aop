package com.brude.springboot.app.aop.springbootaop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.brude.springboot.app.aop.springbootaop.services.GreetingService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap("Greeting", greetingService.sayHello("brude", "bridei")));
    }

     @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {
        return ResponseEntity.ok(Collections.singletonMap("Greeting", greetingService.sayHelloError("brude", "bridei")));
    }
    

}
