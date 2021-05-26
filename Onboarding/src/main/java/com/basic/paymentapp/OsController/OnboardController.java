package com.basic.paymentapp.OsController;

import com.basic.paymentapp.OnboardService.ServiceImpl.BankServiceImpl;
import com.basic.paymentapp.OnboardService.ServiceImpl.UserServiceImpl;
import com.basic.paymentapp.entities.PartnerBanks;
import com.basic.paymentapp.entities.Response;
import com.basic.paymentapp.entities.Users;
import com.basic.paymentapp.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OnboardController {

    private static final Logger log= LoggerFactory.getLogger(OnboardController.class);

    @Autowired
    UserServiceImpl userService;

    @Autowired
    BankServiceImpl bankService;
    @GetMapping(value = "/home")
    public String home()
    {log.info("arUNNING HOME PAGE");
        return "HOME PAGE";}

    @GetMapping(value="/users")
    public ResponseEntity<List<Response>> getAlldata()
    {
        log.info("Request for all the existing users");
        List<Response> list=userService.getAlldata();
        if(list.size()<=0)
        {
            throw new NotFoundException("No users existing");
        }
        log.info("Response of get all users request");
        return new ResponseEntity<List<Response>>(list, HttpStatus.OK);
    }
    @GetMapping(value="/user")
    public ResponseEntity<Users> getuserbyID(@RequestParam("phoneno") String phoneno)
    {
        log.info("Requesting for details of user with " + phoneno+ " id");
        Users re_user=userService.getUserbyId(phoneno);
        return new ResponseEntity<>(re_user,HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<String> addUser(@RequestBody Users user)
    {
        boolean result=userService.addUser(user);
       return new ResponseEntity<>("User Created",HttpStatus.OK);
    }

    @PutMapping(value = "/user")
    public ResponseEntity<String> updateUser(@RequestBody Users user)
    {
        boolean result= userService.updateuser(user);
        return new ResponseEntity<>("User Updated",HttpStatus.OK);
    }

    @GetMapping(value="/banks")
    public ResponseEntity<List<Response>> getAllbankdata()
    {
        log.info("Request for all the existing associated banks data");
        List<Response> list=bankService.getAllbankdata();
        if(list.size()<=0)
        {
            throw new NotFoundException("No associated banks existing");
        }
        log.info("Response of get all banks request");
        return new ResponseEntity<List<Response>>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/bank")
    public ResponseEntity<String> addBank(@RequestBody PartnerBanks partnerBanks)
    {
        boolean result=bankService.addbank(partnerBanks);
        return new ResponseEntity<>("User Created",HttpStatus.OK);
    }


}
