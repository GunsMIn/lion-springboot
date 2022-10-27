package com.springboot.lionboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Hellocontroller {

    @RequestMapping("/hello")
    public String hello() {
        return "aloha world";
    }

    //RequestParam
    @GetMapping("/request1")
    public String getRequesr(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {
        return name + " " + email + " " + organization;
    }


    @GetMapping("/request2")
    public String getres2(@RequestParam Map<String,String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue()+"\n");
        });
        return sb.toString();
    }



}
