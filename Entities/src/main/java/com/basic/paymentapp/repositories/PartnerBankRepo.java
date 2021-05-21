package com.basic.paymentapp.repositories;

import com.basic.paymentapp.entities.PartnerBanks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerBankRepo extends JpaRepository<PartnerBanks,String> {
}
