package com.example.kafkaspringtest.controller;

import java.util.List;
import com.example.kafkaspringtest.data.sender.*;
import com.example.kafkaspringtest.data.consumer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaControllerTest {

  @Autowired
  private Sender sender;

  @Autowired
  private Receiver receiver;

  @RequestMapping(value = "/producer", method = RequestMethod.POST)
  public String producer(@RequestParam("text") String text) {
    sender.send(text);
    return text;
  }

  @RequestMapping(value = "/consumer", method = RequestMethod.GET)
  public List<String> consumer() {
    List<String> messages = receiver.getStorageElements();
    return messages;
  }

}
