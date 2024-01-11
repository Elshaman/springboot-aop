package com.brude.springboot.app.aop.springbootaop.services;

public interface IGreetingService {

    String sayHello(String person, String frase);
    String sayHelloError(String person, String frase);
}
