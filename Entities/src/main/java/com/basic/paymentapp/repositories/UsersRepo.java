package com.basic.paymentapp.repositories;

import com.basic.paymentapp.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users,String> {
     //Users findByPhonenumber(String phone_number);
}

