package com.example.spring_proxy.API.proxies;

import com.example.spring_proxy.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.UUID;

@Component
public class PaymentProxy {

    private final RestTemplate rest;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public PaymentProxy(
            RestTemplate rest
    ) {
        this.rest = rest;
    }

    public Payment createPayment(Payment payment) {
        var uri = paymentServiceUrl + "/payment";
        var headers = new org.springframework.http.HttpHeaders();
        headers.add("requestID", UUID.randomUUID().toString());
        var httpEntity = new HttpEntity<Payment>(payment, headers);
        var response = rest.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);
        return response.getBody();
    }
}
