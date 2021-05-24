package com.basic.paymentapp.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    public String firstname;
    public String lastname;
    public String email;
    @Id
    public String phone_number;
//
    private String password;
}