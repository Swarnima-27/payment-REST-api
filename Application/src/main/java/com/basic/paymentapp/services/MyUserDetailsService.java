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
import java.util.HashMap;
import java.util.Map;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       Users user =usersRepo.findByPhonenumber(username);
//       if(user==null) {
//           throw new UsernameNotFoundException("Could not find User");
//        }
//        return new MyUserDetails(user);
        String uname = null;
        String pass=null;
        Map<String, String> objMap = new HashMap<String, String>();
        objMap.put("0001", "root1");
        objMap.put("0002", "root2");
        objMap.put("0003", "root3");
        objMap.put("0004", "root4");
        objMap.put("0005", "root5");
        for(Map.Entry m : objMap.entrySet())
        {
            uname= (String) m.getKey();
            pass= (String) m.getValue();
        }
        return new User(uname,pass,new ArrayList<>());
    }
}
