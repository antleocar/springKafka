package com.example.kafkaspringtest.data.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

  private CountDownLatch downLatch = new CountDownLatch(1);

  List<String> storageElements = new ArrayList<>();

  public List<String> getStorageElements() {
    return storageElements;
  }

  @KafkaListener(topics = "${spring.kafka.template.default-topic}")
  public void receive(String payload){
    storageElements.add(payload);
    downLatch.countDown();
  }

}
