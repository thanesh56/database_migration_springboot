package com.javatechie.multiple.ds.api.userdb2.repository;

import com.javatechie.multiple.ds.api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDB2Repository extends JpaRepository<User, Integer> {

}
