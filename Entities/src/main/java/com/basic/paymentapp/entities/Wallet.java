package com.basic.paymentapp.entities;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Wallet {
    @Id
    public String walletid;
    public String bankaccount;
    public Double balance;
    public String bankid;

    public Wallet(String walletid, String bankaccount,String bankid) {
        this.walletid = walletid;
        this.bankaccount = bankaccount;
        this.balance = 0.0;
        this.bankid=bankid;
    }
}
