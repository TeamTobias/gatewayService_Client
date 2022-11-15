package com.example.gatewayservice_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceClientApplication.class, args);

    }

}
