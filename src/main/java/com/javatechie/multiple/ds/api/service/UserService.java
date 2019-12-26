package com.javatechie.multiple.ds.api.service;


import com.javatechie.multiple.ds.api.model.user.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    List<User> getAllUser();
    User saveUser(User user);
    void deleteUser();
    void deleteUserById(int id);
}
