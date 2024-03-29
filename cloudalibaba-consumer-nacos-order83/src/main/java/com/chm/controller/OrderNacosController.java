package com.chm.controller;

import com.chm.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;
    @RequestMapping(value = "/consumer/pay/nacos/{id}",method = RequestMethod.GET)
    public ResultData paymentInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverURL + "/pay/nacos/" + id,ResultData.class);
    }
}
