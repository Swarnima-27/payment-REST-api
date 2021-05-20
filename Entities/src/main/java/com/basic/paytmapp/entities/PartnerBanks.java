package com.basic.paytmapp.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PartnerBanks {
    @Id
    public String bankid;
    public String bankname;
}
