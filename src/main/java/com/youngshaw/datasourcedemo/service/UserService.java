package com.youngshaw.datasourcedemo.service;

import com.youngshaw.datasourcedemo.entries.User;

public interface UserService {
    User getUser(Integer id);
    void saveUser(User user);
}
