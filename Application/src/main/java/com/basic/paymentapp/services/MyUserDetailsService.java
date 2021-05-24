package com.basic.paymentapp.services;

import com.basic.paymentapp.entities.Users;
import com.basic.paymentapp.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user =usersRepo.findByPhonenumber(username);
//        if(user==null) {
//            throw new UsernameNotFoundException("Could not find User");
//        }
//        return new User(user.getPhone_number(),user.getPassword(),new ArrayList<>());
        return new User("root","root",new ArrayList<>());
    }
}
