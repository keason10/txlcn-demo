package com.codingapi.example.client.controller;

import com.codingapi.example.client.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description:
 * Date: 2018/12/25
 *
 * @author ujued
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/txlcn",method= RequestMethod.POST)
    public String execute(@RequestBody Map value){
        return demoService.execute(String.valueOf(value.get("name")));
    }
}
