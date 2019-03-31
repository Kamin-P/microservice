package com.example.msa.springboot.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.msa.springboot.repository.dvo.PaymentDVO;

@Mapper
public interface ICoffeePaymentMapper {
    int insertCoffeePayment(PaymentDVO paymentDVO);

    PaymentDVO selectCoffeePayment();

    int createPaymentTable();
}
