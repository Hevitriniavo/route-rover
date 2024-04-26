package com.tantely.routerover.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/say")
public class HelloWorld {
    @GetMapping
    public Map<?, ?> sayHello() {
        return Map.of("message", "Hello, world !");
    }
}
