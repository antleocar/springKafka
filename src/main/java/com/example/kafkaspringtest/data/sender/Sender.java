package com.example.kafkaspringtest.data.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Value("${spring.kafka.template.default-topic}")
  private String kafkaTopic;

  public void send(String text) {
    kafkaTemplate.send(kafkaTopic, text);
  }

}
