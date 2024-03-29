package com.chm.controller;

import com.chm.api.PayFeignApi;
import com.chm.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderGateWayController {
    @Resource
    private PayFeignApi payFeignApi;
    @RequestMapping("/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id){
        return payFeignApi.getById(id);

    }
    @RequestMapping("/feign/pay/geteway/info")
    public ResultData getGatewayInfo(){
        return payFeignApi.getGatewayInfo();
    }
}
