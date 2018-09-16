package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${random.string}")
    private String randomString;

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/randomString")
    public String randdomString(){
        return randomString;
    }

    @RequestMapping("/springApplicationJson")
    public String springApplicationJson(){
        return System.getProperty("SPRING_APPLICATION_JSON");
    }

}
