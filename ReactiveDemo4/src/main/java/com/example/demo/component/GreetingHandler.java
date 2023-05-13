package com.example.demo.component;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

  public Mono greeting(ServerRequest request) {
    return ServerResponse.ok().body(Mono.just("Result111 from Mono"), String.class);
  }
}