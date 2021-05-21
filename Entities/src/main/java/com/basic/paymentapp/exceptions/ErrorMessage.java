package com.basic.paymentapp.exceptions;

import lombok.*;

import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private Timestamp time;
    private String error;

}
