package com.example.msa.springboot.rest;

import com.example.msa.springboot.repository.ICoffeePaymentMapper;
import com.example.msa.springboot.repository.dvo.PaymentDVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Map;

@RestController
public class CoffeePaymentRestController {
    Logger logger = LoggerFactory.getLogger(CoffeePaymentRestController.class);

    @Autowired
    ICoffeePaymentMapper iCoffePaymentMapper;

    @HystrixCommand
    @RequestMapping(value = "/coffeePayment", method = RequestMethod.POST)
    public ResponseEntity<PaymentDVO> coffeePayment() {

        PaymentDVO orderStatusDVO = iCoffePaymentMapper.selectCoffeePayment();

        return new ResponseEntity<PaymentDVO>(orderStatusDVO, HttpStatus.OK);
    }

    @HystrixCommand
    @RequestMapping(value = "/doPayment", method = RequestMethod.POST)
    public ResponseEntity<PaymentDVO> doPayment(@RequestBody Map<String, String> queryMap) {
        System.out.println(queryMap);
        PaymentDVO paymentDVO = new PaymentDVO(queryMap.get("orderId"),
                queryMap.get("customername"),
                Integer.parseInt(queryMap.get("qty")) * 1000);
        iCoffePaymentMapper.insertCoffeePayment(paymentDVO);

        return new ResponseEntity<PaymentDVO>(paymentDVO, HttpStatus.OK);
    }

    @RequestMapping(value = "/createPaymentTable", method = RequestMethod.PUT)
    public void createPaymentTable() {
        iCoffePaymentMapper.createPaymentTable();
    }
}
