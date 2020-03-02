package com.wms;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WMSRestService {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @RequestMapping("/greeting")
    public String greeting() {
        return String.format(
                "Hello from '%s' from instance ID : '%s'", eurekaClient.getApplication(appName).getName(), instanceId);
    }
}
