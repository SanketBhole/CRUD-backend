package com.crud.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.fullstack.exception.UserNotFoundException;
import com.crud.fullstack.model.User;
import com.crud.fullstack.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @Override
    public User updateUser(User newUser, Long id) {
        return userRepository.findById(id).map
        (user ->{
            user.setUsername(newUser.getUsername());
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(()->new UserNotFoundException(id));
    }

    @Override
    public String deleteUser(Long id) {
       if(userRepository.existsById(id)){
        userRepository.deleteById(id);
       return "User with id "+id+" has been deleted";
    }
    throw  new UserNotFoundException(id);
       
    }
    
}
