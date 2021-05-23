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
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
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
            transactionRepo.save(new_transaction);
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
        log.info("Transaction in process from " + from_walletid+" to "+ to_walletid);
        if(walletRepo.existsById(from_walletid)==false)
            throw new NotFoundException("Payer wallet "+from_walletid+" doesn't exists");
        if(walletRepo.existsById(to_walletid) && walletRepo.existsById(from_walletid))
        {
            Wallet payer_wallet=walletRepo.findById(from_walletid).get();
            Wallet payee_wallet=walletRepo.findById(to_walletid).get();

            if(payer_wallet.balance>=amount)
            {
                Double new_balance=payer_wallet.getBalance()-amount;
                payer_wallet.setBalance(new_balance);
                walletRepo.save(payer_wallet);
                Double new_balance1=payee_wallet.getBalance()+amount;
                payee_wallet.setBalance(new_balance1);
                walletRepo.save(payee_wallet);

                Transactions new_transaction= new Transactions();
                new_transaction.setAmount(amount);
                new_transaction.setPayeeid(to_walletid);
                new_transaction.setPayerid(from_walletid);
                new_transaction.setTime(new Timestamp(System.currentTimeMillis()));
                transactionRepo.save(new_transaction);
                return true;
            }
            else
            {
                log.info("NOt enough balance in " + from_walletid);
                throw new NotValidException("NOt enough balance in " + from_walletid);
            }
        }
        else
        {
            log.info("Wallet " + from_walletid+" doesn't exists");
            throw new NotFoundException("Wallet " + from_walletid+" doesn't exists");
        }

    }

    @Override
    public Double checkbalance(String walletid) {
        if(walletRepo.existsById(walletid)==false)
            throw new NotFoundException("Wallet doesn't exists");
        return walletRepo.findById(walletid).get().balance;
    }

    @Override
    public List<Transactions> findbyPayerid(String payerid) {
        return transactionRepo.findByPayerid(payerid);
    }

    @Override
    public List<Transactions> findbyPayeeid(String payeeid) {
        return transactionRepo.findByPayeeid(payeeid);
    }
}
