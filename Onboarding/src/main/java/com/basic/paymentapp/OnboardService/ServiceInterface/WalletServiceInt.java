package com.basic.paymentapp.OnboardService.ServiceInterface;

import com.basic.paymentapp.entities.Wallet;
import org.springframework.stereotype.Service;

@Service
public interface WalletServiceInt {
    public boolean check(String phoneno);
    public void save(Wallet wallet);
    Wallet getwallet(String phoneno);
}
