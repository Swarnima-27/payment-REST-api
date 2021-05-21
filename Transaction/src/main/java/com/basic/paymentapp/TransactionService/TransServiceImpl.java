package com.basic.paymentapp.TransactionService;

import com.basic.paymentapp.entities.Transactions;
import com.basic.paymentapp.entities.Wallet;
import com.basic.paymentapp.exceptions.NotFoundException;
import com.basic.paymentapp.exceptions.NotValidException;
import com.basic.paymentapp.repositories.PartnerBankRepo;
import com.basic.paymentapp.repositories.TransactionRepo;
import com.basic.paymentapp.repositories.WalletRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

public class TransServiceImpl  implements TransServiceInt{

    private static final Logger log= LoggerFactory.getLogger(TransServiceImpl.class);

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    WalletRepo walletRepo;

    @Autowired
    PartnerBankRepo partnerBankRepo;

    @Override
    public boolean addmoney(String walletid, Double amount) {
        log.debug("Process of adding money to wallet initiated");
        if(walletRepo.existsById(walletid)==false)
        {
            throw new NotFoundException("Wallet not found.Doesn't exists");
        }
        String Bid=walletRepo.findById(walletid).get().bankid;
        if(partnerBankRepo.existsById(walletid))
        {
            log.info("Requesting bank to access " + walletRepo.findById(walletid).get().bankaccount+" account for transaction");
            log.info("Checking enough balance");
            Wallet wallet=walletRepo.findById(walletid).get();
            Double new_balance=wallet.getBalance()+amount;
            wallet.setBalance(new_balance);
            log.info("Asking bank for amount deduction");
            walletRepo.save(wallet);


            Transactions new_transaction= new Transactions();
            new_transaction.setAmount(amount);
            new_transaction.setPayeeid(walletid);
            new_transaction.setPayerid(walletRepo.findById(walletid).get().bankaccount);
            new_transaction.setTime(new Timestamp(System.currentTimeMillis()));
            return true;
        }
        else
        {
            log.debug("Bank is not partner");
            throw new NotValidException("Bank is not partner.Cannot process transaction");
        }
    }

    @Override
    public boolean transfermoney(String to_walletid, String from_walletid, Double amount) {
        return false;
    }

    @Override
    public Double checkbalance(String walletid) {
        return null;
    }

    @Override
    public List<Transaction> findbyPayerid(String payerid) {
        return null;
    }

    @Override
    public List<Transaction> findbyPayeeid(String payeeid) {
        return null;
    }
}
