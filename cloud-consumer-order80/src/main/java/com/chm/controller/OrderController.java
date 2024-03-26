package com.chm.controller;

import com.chm.entities.PayDTO;
import com.chm.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
//    public static final String PaymentSrv_URL = "http://localhost:8001";
    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add",payDTO,ResultData.class);
    }
    @RequestMapping("/consumer/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id ,ResultData.class);
    }
    @RequestMapping("/consumer/pay/update")
    public ResultData updateOrder(PayDTO payDTO){


//        restTemplate.put(PaymentSrv_URL + "/pay/update",payDTO);
        HttpEntity<PayDTO> entity = new HttpEntity<>(payDTO);
        ResultData result = restTemplate.exchange(PaymentSrv_URL + "/pay/update", HttpMethod.PUT, entity, ResultData.class).getBody();
        return result;
    }
    @RequestMapping("/consumer/pay/del/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id ){
//        restTemplate.delete(PaymentSrv_URL + "/pay/del/" + id);
        HttpEntity entity = new HttpEntity(null);
        ResultData result = restTemplate.exchange(PaymentSrv_URL + "/pay/del/" + id, HttpMethod.DELETE, entity, ResultData.class).getBody();

        return result;
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }
}
