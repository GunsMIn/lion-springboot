package com.springboot.lionboot.pratice.domain.controller;

import com.springboot.lionboot.pratice.domain.User;
import com.springboot.lionboot.pratice.domain.repository.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @DeleteMapping("/members")
    public String remove() {
        userDao.deleteAll();
        return "유저 전체가 삭제되었습니다";
    }





}
