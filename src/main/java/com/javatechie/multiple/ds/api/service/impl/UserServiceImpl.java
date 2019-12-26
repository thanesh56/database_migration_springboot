package com.javatechie.multiple.ds.api.service.impl;

import com.javatechie.multiple.ds.api.model.user.User;
import com.javatechie.multiple.ds.api.service.UserService;
import com.javatechie.multiple.ds.api.user.repository.UserRepository;
import com.javatechie.multiple.ds.api.userdb2.repository.UserDB2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDB2Repository userDB2Repository;

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not Found of this Id"+id));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public User saveUser(User user) {
        return userDB2Repository.save(user);
    }

    @Override
    public void deleteUser() {
        userDB2Repository.deleteAll();

    }

    @Override
    public void deleteUserById(int id) {
       userRepository.deleteById(id);
    }
}
