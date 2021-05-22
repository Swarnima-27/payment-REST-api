package com.basic.paymentapp.OnboardService.ServiceImpl;

import com.basic.paymentapp.OnboardService.ServiceInterface.UserServiceInt;
import com.basic.paymentapp.entities.Response;
import com.basic.paymentapp.entities.Users;
import com.basic.paymentapp.exceptions.AlreadyExistsException;
import com.basic.paymentapp.exceptions.EmptyInputException;
import com.basic.paymentapp.exceptions.NotFoundException;
import com.basic.paymentapp.repositories.UsersRepo;
import com.basic.paymentapp.repositories.WalletRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserServiceInt {

    private static final Logger log= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    WalletRepo walletRepo;

    @Override
    public List<Response> getAlldata() {
        List<Response> userlist= new ArrayList<>();
        usersRepo.findAll().forEach(entity->{
            try{
                userlist.add(new Response("success",entity,"No error"));
            }
            catch(Exception exception)
            {
                userlist.add(new Response("Error in loading",null,exception.getMessage()));
            }
        });
        return userlist;

    }

    @Override
    public boolean addUser(Users user) {
        if(user.getEmail().isEmpty() || user.getFirstname().isEmpty() || user.getPhone_number().isEmpty())
            throw new EmptyInputException("Values cannot be null");
        else if(usersRepo.findById(user.getPhone_number()).isPresent())
        {
            log.info("User already exists with "+ user.getPhone_number()+" phone number");
            throw new AlreadyExistsException("User already exists with "+ user.getPhone_number()+" phone number");
        }
        else
        {
            usersRepo.save(user);
            log.info("User Created");
            return true;
        }
    }

    @Override
    public boolean updateuser(Users user) {
        if(user.getEmail().isEmpty() || user.getFirstname().isEmpty() || user.getPhone_number().isEmpty())
            throw new EmptyInputException("Values cannot be null");
        else if(usersRepo.findById(user.getPhone_number()).isPresent())
        {
            usersRepo.save(user);
            log.info("User Updated");
            return true;
        }
        else
        {
            log.info("User does not exists");
            throw new NotFoundException("User already exists with "+ user.getPhone_number()+" phone number");
        }
    }

    @Override
    public Users getUserbyId(String Phoneno) {
        Optional<Users> user1=usersRepo.findById(Phoneno);
        if(user1.isPresent())
        {
            log.info("User info available " + user1.get());
            return user1.get();
        }
        else
        {
            log.info("User with " + Phoneno + " does not exists");
            throw new NotFoundException("User with " + Phoneno + " does not exists");
        }
    }
}
