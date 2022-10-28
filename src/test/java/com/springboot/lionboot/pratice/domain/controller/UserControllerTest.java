package com.springboot.lionboot.pratice.domain.controller;

import com.springboot.lionboot.pratice.domain.User;
import com.springboot.lionboot.pratice.domain.repository.UserDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @Autowired private UserDao userDao;

    User user1;
    User user2;
    User user3;

    @BeforeEach
    void setUp() {
        this.user1 = new User("30", "김xx", "1234");
        this.user2 = new User("31", "이xx", "1234");
        this.user3 = new User("32", "박xx", "1234");
    }



    @Test
    public void 회원가입테스트() {
        User user = new User("1","김건우","1234");
        userDao.add(user);

        User byId = userDao.findById("1");
        Assertions.assertEquals(byId.getName(),user.getName());
    }


    @Test
    public void 회원id로삭제() {
        userDao.deleteById("30")
        ;
    }


    @Test
    public void 회원전체삭제테스트() {
        int value = userDao.deleteAll();
        Assertions.assertEquals(0,value);
    }



}