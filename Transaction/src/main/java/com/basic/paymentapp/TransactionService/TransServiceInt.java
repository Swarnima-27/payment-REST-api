package com.basic.paymentapp.TransactionService;

import com.basic.paymentapp.entities.Transactions;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;

@Service
public interface TransServiceInt {
    public boolean addmoney(String walletid,Double amount);
    public boolean transfermoney(String to_walletid,String from_walletid,Double amount);
    public Double checkbalance(String walletid);
    public List<Transactions> findbyPayerid(String payerid);
    public List<Transactions> findbyPayeeid(String payeeid);
}
