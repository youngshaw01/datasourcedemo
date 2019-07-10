package com.youngshaw.datasourcedemo.service.impl;

import com.youngshaw.datasourcedemo.config.Master;
import com.youngshaw.datasourcedemo.dao.UserDao;
import com.youngshaw.datasourcedemo.entries.User;
import com.youngshaw.datasourcedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Integer id) {
        return userDao.getUserById(id);
    }

    @Master
    @Transactional
    @Override
    public void saveUser(User user){

    }
}
