package com.luv2code.restapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestappRestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
