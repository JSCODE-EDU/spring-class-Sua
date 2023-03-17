package com.example.springclassdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springclassdemo.logSample.Slf4jSample;

//@Slf4j
@RestController
public class StringController {

    @GetMapping("/api/test")
    public String test() {
        return "test";
    }

    @GetMapping("/name")
    public String viewName(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        Slf4jSample logger = new Slf4jSample();
        logger.namelogger(name);

        return name;
    }
}
