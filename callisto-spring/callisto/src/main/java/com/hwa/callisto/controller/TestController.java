package com.hwa.callisto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    public String testController() {
        return "test";
    }

    @GetMapping("/index")
    public int indexController() {
        return 1;
    }
}
