package com.youngshaw.datasourcedemo.dao;


import com.youngshaw.datasourcedemo.entries.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserById(Integer id);
}
