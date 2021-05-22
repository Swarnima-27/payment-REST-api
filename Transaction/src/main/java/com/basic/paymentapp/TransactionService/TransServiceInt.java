package com.basic.paymentapp.TransactionService;

import com.basic.paymentapp.entities.Transactions;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;

@Service
public interface TransServiceInt {
     boolean addmoney(String walletid,Double amount);
     boolean transfermoney(String to_walletid,String from_walletid,Double amount);
     Double checkbalance(String walletid);
     List<Transactions> findbyPayerid(String payerid);
     List<Transactions> findbyPayeeid(String payeeid);
}
