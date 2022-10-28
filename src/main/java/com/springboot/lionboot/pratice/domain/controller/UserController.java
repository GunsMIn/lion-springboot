package com.springboot.lionboot.pratice.domain.controller;

import com.springboot.lionboot.pratice.domain.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserController {

    private final UserDao userDao;



}
