package com.example.msa.springboot.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Data
public class ServiceConfig {
    @Value("${msaconfig.greeting}")
    private String greeting;
}
