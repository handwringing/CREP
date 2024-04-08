package com.crep.service;

import com.crep.entity.User;
import com.crep.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface UserService {
    User findById(Integer userId);
    int createUser(User user);
    int updateUser(User user);
    int deleteUser(Integer userId);
    List<User> findAllUsers();
    User findByUsername(String username);
}

