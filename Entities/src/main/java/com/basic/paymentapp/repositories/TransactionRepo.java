package com.basic.paymentapp.repositories;

import com.basic.paymentapp.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions,String> {
}
