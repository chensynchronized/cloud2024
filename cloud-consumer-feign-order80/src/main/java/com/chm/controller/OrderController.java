package com.chm.controller;

import com.chm.api.PayFeignApi;
import com.chm.entities.PayDTO;
import com.chm.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @RequestMapping("/feign/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return payFeignApi.addPay(payDTO);
    }
    @RequestMapping("/feign/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id){
        return payFeignApi.getById(id);

    }
    @RequestMapping("/feign/pay/update")
    public ResultData updateOrder(PayDTO payDTO){
        return payFeignApi.updatePay(payDTO);
    }
    @RequestMapping("/feign/pay/del/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id ){
        return payFeignApi.deletePay(id);
    }

    @GetMapping(value = "/feign/pay/get/info")
    private ResultData getPayInfo()
    {
        return payFeignApi.getPayInfo();
    }
}
