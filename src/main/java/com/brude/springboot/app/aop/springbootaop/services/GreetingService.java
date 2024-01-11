package com.brude.springboot.app.aop.springbootaop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService {

    @Override
    public String sayHello(String person, String frase) {
        // TODO Auto-generated method stub
        String greeting = person + " " + frase;
        System.out.println(greeting);
        return greeting;
    }

    @Override
    public String sayHelloError(String person, String frase) {
        throw new RuntimeException("aalgun error");
    }

    

    
}
