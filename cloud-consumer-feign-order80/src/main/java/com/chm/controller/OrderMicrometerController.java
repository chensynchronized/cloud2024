package com.chm.controller;

import com.chm.api.PayFeignApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderMicrometerController {
    @Resource
    private PayFeignApi payFeignApi;
    @RequestMapping("/feign/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id){
        return payFeignApi.myMicrometer(id);
    }
}
