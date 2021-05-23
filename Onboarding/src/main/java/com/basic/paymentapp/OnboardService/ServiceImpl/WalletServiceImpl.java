package com.basic.paymentapp.OnboardService.ServiceImpl;

import com.basic.paymentapp.OnboardService.ServiceInterface.WalletServiceInt;
import com.basic.paymentapp.entities.Wallet;
import com.basic.paymentapp.exceptions.NotFoundException;
import com.basic.paymentapp.repositories.WalletRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletServiceInt {

    private static final Logger log= LoggerFactory.getLogger(WalletServiceImpl.class);
    @Autowired
    WalletRepo walletRepo;

    @Override
    public boolean check(String phoneno) {
        return walletRepo.findById(phoneno).isPresent();
    }

    @Override
    public void save(Wallet wallet) {
        walletRepo.save(wallet);
    }

    @Override
    public Wallet getwallet(String phoneno) {
        if(walletRepo.findById(phoneno).isPresent())
            return walletRepo.findById(phoneno).get();
        else
            throw new NotFoundException("WalletID " + phoneno + " not found");
    }
}
