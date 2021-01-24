package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class WelcomeController {

    @Value("${custom.developer}")
    private String serviceName;

    @GetMapping("/service")
    public String getServiceName() {
        return "service name [" + this.serviceName + "]";
    }

}
