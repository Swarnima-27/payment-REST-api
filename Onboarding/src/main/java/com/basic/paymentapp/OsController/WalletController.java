package com.basic.paymentapp.OsController;

import com.basic.paymentapp.OnboardService.ServiceImpl.UserServiceImpl;
import com.basic.paymentapp.OnboardService.ServiceImpl.WalletServiceImpl;
import com.basic.paymentapp.entities.Wallet;
import com.basic.paymentapp.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
    private static final Logger log= LoggerFactory.getLogger(WalletController.class);

    @Autowired
    WalletServiceImpl walletService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping(value="/wallet")
    public ResponseEntity<String> activateWallet(@RequestParam("walletid") String Phoneno,
                                                 @RequestParam("bankid") String bankid,
                                                 @RequestParam("accountnumber") String accountnumber)
    {
        boolean result=walletService.check(Phoneno);
        if(result)
        {
            if(userService.getUserbyId(Phoneno)==null)
                throw new NotFoundException("User doesn't exists");
            else
                return  new ResponseEntity<String>("Walley already exists with id " + Phoneno, HttpStatus.BAD_REQUEST);
        }
        else
        {
            Wallet wallet=new Wallet(Phoneno,bankid,accountnumber);
            walletService.save(wallet);
            return new ResponseEntity<String>("Wallet activated",HttpStatus.CREATED);
        }
    }

    @GetMapping(value="/wallet")
    public ResponseEntity<Wallet> getWallet(@RequestParam("walletid") String Phoneno)
    {
        return new ResponseEntity<Wallet>(walletService.getwallet(Phoneno),HttpStatus.OK);
    }
}
