package com.arayastudio.quickchat.domain;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
  private Instant timestamp;
  private String name;
  private String message;

  public Chat(String name, String message) {
    this.timestamp = Instant.now();
    this.name = name;
    this.message = message;
  }

  public String toString() {
    return String.format("%s (%s): %s", name, timestamp.toString(), message);
  }
}
