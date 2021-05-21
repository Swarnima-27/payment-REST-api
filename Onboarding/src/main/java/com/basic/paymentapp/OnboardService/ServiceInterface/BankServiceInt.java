package com.basic.paymentapp.OnboardService.ServiceInterface;

import com.basic.paymentapp.entities.PartnerBanks;
import com.basic.paymentapp.entities.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankServiceInt {
    public boolean addbank(PartnerBanks partnerBanks);
    public List<Response> getAllbankdata();
}
