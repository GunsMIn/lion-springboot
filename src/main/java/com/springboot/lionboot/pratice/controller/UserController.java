package com.springboot.lionboot.pratice.domain.controller;

import com.springboot.lionboot.pratice.domain.domain.User;
import com.springboot.lionboot.pratice.domain.repository.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/members/{id}")
    public User get(@PathVariable String id) {
        User byId = userDao.findById(id);
        return byId;
    }

    //회원 전체 조회
    @GetMapping("/members")
    public List<User> getAll() {
        List<User> all = userDao.getAll();
        return all;
    }

    //등록
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

    //전체 삭제
    @DeleteMapping("/members")
    public String removeAll() {
        userDao.deleteAll();
        return "유저 전체가 삭제되었습니다";
    }






}
