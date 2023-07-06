package com.crud.fullstack.service;

import java.util.List;

import com.crud.fullstack.model.User;

public interface UserService {
    public User save(User user);
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User updateUser(User user, Long id);
    public String deleteUser(Long id);
 }
