package com.basic.paymentapp.services;

import com.basic.paymentapp.entities.Users;
import com.basic.paymentapp.exceptions.NotValidException;
import com.basic.paymentapp.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String uname = null;
        String pass=null;
        if(usersRepo.existsById(username))
        {
            uname=usersRepo.findById(username).get().phone_number;
            pass=usersRepo.findById(username).get().getPassword();
        }
        else
        {
            throw new NotValidException("Username or password not valid");
        }
        return new User(uname,pass,new ArrayList<>());
    }
}
