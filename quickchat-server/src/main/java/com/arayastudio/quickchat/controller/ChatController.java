package com.arayastudio.quickchat.controller;

import com.arayastudio.quickchat.domain.Chat;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

  @MessageMapping("chatReceiver")
  public Chat receiveMessage(Chat incoming) {
    System.out.println(incoming.toString());
    return new Chat("Bot B:", "Hello back.");
  }

}

