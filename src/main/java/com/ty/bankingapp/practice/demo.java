package com.ty.bankingapp.practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/welcome")
public class demo {
    @GetMapping
    public String welcome(){
        return "Welcome to bankign App";
    }
}
