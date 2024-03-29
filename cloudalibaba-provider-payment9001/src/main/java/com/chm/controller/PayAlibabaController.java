package com.chm.controller;

import com.chm.resp.ResultData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayAlibabaController {
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value = "/pay/nacos/{id}",method = RequestMethod.GET)
    public ResultData<String> getPayInfo(@PathVariable("id") Integer id){
        return ResultData.success("nacos registry, serverPort: "+ serverPort+"\t id"+id);
    }
}
