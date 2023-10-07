package com.example.spring_proxy;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(
        basePackages = "com.example.spring_proxy.API.proxy_objects")
public class ProjectConfiguration { }
