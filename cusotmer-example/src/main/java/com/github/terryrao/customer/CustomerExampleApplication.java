package com.github.terryrao.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author raowei
 * @date 2019-08-16
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CustomerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerExampleApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }




}
