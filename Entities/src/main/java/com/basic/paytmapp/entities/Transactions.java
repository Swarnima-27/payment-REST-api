package com.basic.paytmapp.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;


@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    @Id
    public String transID;
    public String payerid;
    public String payeeid;
    public Double amount;
    public Timestamp time;
    public String description;

}
