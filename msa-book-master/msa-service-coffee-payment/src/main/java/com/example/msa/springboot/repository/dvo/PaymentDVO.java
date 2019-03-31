package com.example.msa.springboot.repository.dvo;

import lombok.Data;

@Data
public class PaymentDVO {
    private String id;
    private String orderId;
    private String customerName;
    private int price;

    public PaymentDVO() {}

    public PaymentDVO(String orderId, String customerName, int price) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.price = price;
    }
}
