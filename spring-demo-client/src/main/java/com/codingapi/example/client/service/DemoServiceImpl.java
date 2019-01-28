package com.codingapi.example.client.service;

import com.codingapi.example.client.mapper.ClientDemoMapper;
import com.codingapi.example.common.db.domain.Demo;
import com.codingapi.example.common.spring.DDemoClient;
import com.codingapi.example.common.spring.EDemoClient;
import com.codingapi.txlcn.client.bean.DTXLocal;
import com.codingapi.txlcn.commons.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Description:
 * Date: 2018/12/25
 *
 * @author ujued
 */
@Service
@Order(Integer.MIN_VALUE)
public class DemoServiceImpl implements DemoService {

    private final ClientDemoMapper demoMapper;

    private final DDemoClient dDemoClient;

    private final EDemoClient eDemoClient;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    public DemoServiceImpl(ClientDemoMapper demoMapper, DDemoClient dDemoClient, EDemoClient eDemoClient) {
        this.demoMapper = demoMapper;
        this.dDemoClient = dDemoClient;
        this.eDemoClient = eDemoClient;
    }

    @LcnTransaction
    @Transactional
    public String execute(String value) {
        String dResp = this.dDemoClient.rpc(value);
        String eResp = this.eDemoClient.rpc(value);
        Demo demo = new Demo();
        demo.setDemoField(value);
        demo.setAppName(this.appName);
        demo.setCreateTime(new Date());
        demo.setGroupId(DTXLocal.getOrNew().getGroupId());
        demo.setUnitId(DTXLocal.getOrNew().getUnitId());
//        demoMapper.save(demo);
        int i = 1 / 0;
        return dResp + " > " + eResp + " > " + "ok-client";
    }


}
