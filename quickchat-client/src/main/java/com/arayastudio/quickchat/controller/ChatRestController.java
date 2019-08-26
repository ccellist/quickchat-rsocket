package com.arayastudio.quickchat.controller;

import com.arayastudio.quickchat.domain.Chat;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRestController {

  private final RSocketRequester rSocketRequester;

  @Autowired
  public ChatRestController(RSocketRequester rSocketRequester) {
    this.rSocketRequester = rSocketRequester;
  }
  @PostMapping(value = "/chat")
  public Publisher<Chat> sendMessage(@RequestBody String msg) {
    return rSocketRequester
        .route("chatReceiver")
        .data(new Chat("Bot A:", msg))
        .retrieveMono(Chat.class);
  }
}
