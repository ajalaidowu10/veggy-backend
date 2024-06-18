package com.veggy.backend.veggy_backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController()
public class ItemController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
