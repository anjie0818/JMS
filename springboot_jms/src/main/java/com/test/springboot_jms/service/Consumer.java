package com.test.springboot_jms.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {
    @JmsListener(destination = "sboot")
    public void readMessage(String text){
        System.out.println("接收到消息："+text);
    }
    @JmsListener(destination="sboot_map")
    public void readMap(Map map){
        System.out.println(map);
    }

}
