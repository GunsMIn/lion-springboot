package com.springboot.lionboot.controller;


import com.springboot.lionboot.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
@Slf4j
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "HELLO I.M POST";
    }

    @PostMapping(value = "/members")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(m -> {
            sb.append(m.getKey() + " : " + m.getValue() + "\n");
        });
        return sb.toString();
    }

    @PostMapping(value = "/members2")
    public String postdto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PostMapping(value = "/members3")
    public MemberDto postdto2(@RequestBody MemberDto memberDto) {
        log.info("다음과 같은 member가 들어왔습니다 member :{}",memberDto);
        return memberDto;
    }
}
