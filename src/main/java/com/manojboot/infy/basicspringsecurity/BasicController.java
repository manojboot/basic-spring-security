package com.manojboot.infy.basicspringsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class BasicController {
    @GetMapping("/hello")
    public String hello(){
        return "This is Good Morning Greetings";
    }

    @GetMapping("/secure/hello")
    public String securedHello(){
        return "This is Good Morning Greetings in Secured Way";
    }
}
