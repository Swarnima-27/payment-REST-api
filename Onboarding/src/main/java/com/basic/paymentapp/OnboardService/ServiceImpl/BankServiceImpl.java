package com.basic.paymentapp.OnboardService.ServiceImpl;

import com.basic.paymentapp.OnboardService.ServiceInterface.BankServiceInt;
import com.basic.paymentapp.entities.PartnerBanks;
import com.basic.paymentapp.entities.Response;
import com.basic.paymentapp.exceptions.AlreadyExistsException;
import com.basic.paymentapp.repositories.PartnerBankRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankServiceInt {
    private static final Logger log= LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    PartnerBankRepo partnerBankRepo;

    @Override
    @Cacheable(cacheNames = "banks")
    public boolean addbank(PartnerBanks partnerBanks) {
        if(partnerBankRepo.existsById(partnerBanks.getBankid()))
        {
            log.info(partnerBanks.getBankid()+" already exists");
            throw new AlreadyExistsException(partnerBanks.getBankid()+" already exists");
        }
        else
        {
            partnerBankRepo.save(partnerBanks);
            log.info("Bank saved");
            return true;
        }
    }

    @Override
    @Cacheable(cacheNames = "banks")
    public List<Response> getAllbankdata() {
        List<Response> banklist= new ArrayList<>();
        partnerBankRepo.findAll().forEach(entity->{
            try{
                banklist.add(new Response("success",entity,"No error"));
            }
            catch(Exception exception)
            {
                banklist.add(new Response("Error in loading",null,exception.getMessage()));
            }
        });
        return banklist;
    }
}
