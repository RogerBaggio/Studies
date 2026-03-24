package com.rojudo.spring_lab.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        return "Pong!";
    }

}