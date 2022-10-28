package com.springboot.lionboot.pratice.domain.controller;

import com.springboot.lionboot.pratice.domain.User;
import com.springboot.lionboot.pratice.domain.repository.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserDao userDao;

    @PostMapping("/members")
    public User join(@ModelAttribute User user) {
        userDao.add(user);
        log.info("회원가입할 user = {}" , user);
        return user;
    }

    @DeleteMapping("/members/{id}")
    public String removeOne(@PathVariable String id) {
        userDao.deleteById(id);
        return "유저 한명이 삭제되었습니다.";
    }


    @DeleteMapping("/members")
    public String removeAll() {
        userDao.deleteAll();
        return "유저 전체가 삭제되었습니다";
    }





}
