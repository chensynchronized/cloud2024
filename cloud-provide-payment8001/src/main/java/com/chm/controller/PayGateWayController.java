package com.chm.controller;

import cn.hutool.core.util.IdUtil;
import com.chm.entities.Pay;
import com.chm.entities.PayDTO;
import com.chm.resp.ResultData;
import com.chm.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class PayGateWayController {
    @Resource
    private PayService payService;
    @RequestMapping("/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id){
        Pay pay = payService.getById(id);
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(pay, payDTO);
        log.info("通过gateway网关访问服务提供者8001");
        return ResultData.success(pay);
    }
    @RequestMapping("pay/gateway/info")
    public ResultData<String> getGatewayInfo(){
        return ResultData.success("通过gateway网关访问服务提供者8001," + IdUtil.simpleUUID());
    }


}
