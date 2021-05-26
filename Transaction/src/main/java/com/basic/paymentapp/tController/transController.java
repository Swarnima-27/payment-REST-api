package com.basic.paymentapp.tController;

import com.basic.paymentapp.TransactionService.TransServiceImpl;
import com.basic.paymentapp.entities.Transactions;
import com.basic.paymentapp.exceptions.NotFoundException;
import com.basic.paymentapp.exceptions.NotValidException;
import com.basic.paymentapp.exceptions.TransactionFailedException;
import com.basic.paymentapp.repositories.WalletRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/transaction")
public class transController {
    private static final Logger log= LoggerFactory.getLogger(transController.class);
    @Autowired
    WalletRepo walletRepo;

    @Autowired
    TransServiceImpl transService;

    @PostMapping(value="/transfer")
    public ResponseEntity<Transactions> transferMoney(@RequestParam("walletid1") String to_walletid,
                                                @RequestParam("walletid2") String from_walletid,
                                                @RequestParam("amount") Double amount)
    {
        if(amount<=0)
            throw new NotValidException("Amount Not Valid");
        Transactions result=transService.transfermoney(to_walletid,from_walletid,amount);
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value="/balance")
    public ResponseEntity<String> checkbalance(@RequestParam("walletid") String walletid)
    {
        if(walletRepo.existsById(walletid))
        {
            Double balance= transService.checkbalance(walletid);
            return new ResponseEntity<>("Balance : "+ balance,HttpStatus.OK);
        }
        else
        {
            log.info("WAllet doesn't exists");
            throw new NotFoundException("Wallet with ID : " + walletid+" doesn't exists");
        }
    }

    @PostMapping(value="/addmoney")
    public ResponseEntity<Transactions> addmoney(@RequestParam("walletid") String walletid,
                                           @RequestParam("amount") Double amount)
    {
        if(amount<=0)
            throw new NotValidException("Amount Not Valid");
        Transactions result=transService.addmoney(walletid,amount);
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/transferby")
    public ResponseEntity<List<Transactions>> findbyPayerid(@RequestParam("walletid") String walletid)
    {
        List<Transactions> translist=transService.findbyPayerid(walletid);
        if(translist.size()<=0)
        {
            log.warn("No transaction or user does not exists");
            throw new NotFoundException("No transaction or user does not exists");
        }
        else
            return new ResponseEntity<>(translist,HttpStatus.OK);
    }
}
