package com.test.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-jms-producer.xml")
public class TopicProducterTest {
    @Autowired
    private TopicProducer topicProducer;
    @Test
    public void sendTextTopic(){
        topicProducer.sendTextMessage("SpringJms-发布订阅");
    }
}
