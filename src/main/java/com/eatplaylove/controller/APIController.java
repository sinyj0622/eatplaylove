package com.eatplaylove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@RestController = @Controller + @ResponseBody
public class APIController {

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }
}
