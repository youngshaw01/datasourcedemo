package com.youngshaw.datasourcedemo;

import com.youngshaw.datasourcedemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourcedemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserService userService;


    @Test
    public void testRead() {
        userService.getUser(1);
    }

}
