package com.basic.paymentapp.entities;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String status;
    private Object Data;
    private String detail;


}
