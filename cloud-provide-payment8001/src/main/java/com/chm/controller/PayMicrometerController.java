package com.chm.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayMicrometerController {
    @RequestMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id){
        return "Hello, 欢迎到来myMicrometer inputId:  "+id+" \t    服务返回:" + IdUtil.simpleUUID();
    }
}
