package com.mercadao.eurekaserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/health")
public class HelloGradleController {

    @GetMapping
    public String helloGradle() {
        return "200";
    }

}