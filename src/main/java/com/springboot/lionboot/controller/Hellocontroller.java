package com.springboot.lionboot.controller;

import com.springboot.lionboot.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/request3")
    public String getdto(@ModelAttribute MemberDto memberDto) {
        String name = memberDto.getName();
        String email = memberDto.getEmail();
        String organization = memberDto.getOrganization();
        return name + " " + email + " " + organization;
    }


}
