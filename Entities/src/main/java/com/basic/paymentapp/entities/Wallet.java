package com.basic.paymentapp.entities;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

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
    //for optimistic locking
    @Version
    private int version;

    public Wallet(String walletid, String bankaccount,String bankid) {
        this.walletid = walletid;
        this.bankaccount = bankaccount;
        this.balance = 0.0;
        this.bankid=bankid;
    }
}
