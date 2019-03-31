package com.example.msa.springboot.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("msa-service-coffee-payment")
public interface IMsaServiceCoffeePayment {

    @RequestMapping(value = "/doPayment", method = RequestMethod.POST)
    boolean payment(Map<String, ?> queryMap);
}
