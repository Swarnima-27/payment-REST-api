package com.basic.paytmapp.repositories;

import com.basic.paytmapp.entities.PartnerBanks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerBankRepo extends JpaRepository<PartnerBanks,String> {
}
