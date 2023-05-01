package com.example.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

  @Bean
  public RouterFunction<ServerResponse> routes(GreetingHandler greetingHandler) {
    return RouterFunctions.route(RequestPredicates.GET("/mono1"), greetingHandler::greeting);
  }
}
