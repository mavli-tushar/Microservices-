package com.tushar.user.services.UserServices.services;

import com.tushar.user.services.UserServices.exception.ResourceNotFoundException;
import com.tushar.user.services.UserServices.model.User;
import com.tushar.user.services.UserServices.reposetory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServices {
    @Autowired
    private UserRepo userRepo;
    public User saveUser(User user){
        String s = UUID.randomUUID().toString();
        user.setUserId(s);
        return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUserById(String userId){
        return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not found:"+userId));

    }

}
