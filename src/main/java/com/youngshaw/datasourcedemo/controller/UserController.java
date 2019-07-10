package com.youngshaw.datasourcedemo.controller;

import com.youngshaw.datasourcedemo.entries.User;
import com.youngshaw.datasourcedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);
        return user;
    }
}
