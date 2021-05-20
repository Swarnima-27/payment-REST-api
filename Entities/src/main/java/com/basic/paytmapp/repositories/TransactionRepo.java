package com.basic.paytmapp.repositories;

import com.basic.paytmapp.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions,String> {
}
