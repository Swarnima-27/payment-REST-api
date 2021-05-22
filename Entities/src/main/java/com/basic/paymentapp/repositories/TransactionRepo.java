package com.basic.paymentapp.repositories;

import com.basic.paymentapp.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions,String> {
    List<Transactions> findByPayerid(String payerid);
    List<Transactions> findByPayeeid(String payeeid);
}
