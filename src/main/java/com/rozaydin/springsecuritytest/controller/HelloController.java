package com.rozaydin.springsecuritytest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/csrf")
    public String csrfToken() {
        return "csrf token is set";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "hello there!";
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "bye bye";
    }

}
