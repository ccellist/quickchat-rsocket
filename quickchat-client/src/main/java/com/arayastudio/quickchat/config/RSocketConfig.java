package com.arayastudio.quickchat.config;

import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.MetadataExtractor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.MimeTypeUtils;
import reactor.core.publisher.Mono;

@Configuration
public class RSocketConfig {
  @Value("${quickchat.server.port}")
  private Integer quickchatPort;

  @Bean
  public RSocket rSocket() {
    return RSocketFactory
        .connect()
        .mimeType(MetadataExtractor.ROUTING.toString(), MimeTypeUtils.APPLICATION_JSON_VALUE)
        .frameDecoder(PayloadDecoder.ZERO_COPY)
        .transport(TcpClientTransport.create(quickchatPort))
        .start()
        .block();
  }

  @Bean
  RSocketRequester rSocketRequester(RSocketStrategies rSocketStrategies) {
    return RSocketRequester
        .wrap(rSocket(), MimeTypeUtils.APPLICATION_JSON, MimeTypeUtils.APPLICATION_JSON,
            rSocketStrategies);
  }
}
