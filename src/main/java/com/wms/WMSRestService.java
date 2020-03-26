package com.wms;

import com.netflix.discovery.EurekaClient;
import com.wms.repository.WMSInfo;
import com.wms.repository.WMSInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WMSRestService {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @Autowired
    WMSInfoRepository wmsInfoRepository;

    @RequestMapping("/greeting")
    public String greeting() {
        List<WMSInfo> list = wmsInfoRepository.findAll();

        return String.format(
                "FROM '%s' from instance ID : '%s'  <br/><br/><br/><br/> %s",
                eurekaClient.getApplication(appName).getName(),
                instanceId,
                list.toString());
    }
}
