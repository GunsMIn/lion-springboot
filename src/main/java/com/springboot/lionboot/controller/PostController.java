package com.springboot.lionboot.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "HELLO I.M POST";
    }

    @PostMapping(value = "/members")
    public String postMember(@RequestBody Map<String,Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(m->{
            sb.append(m.getKey() + " : " + m.getValue() + "\n");
        });
        return sb.toString();
    }
}
