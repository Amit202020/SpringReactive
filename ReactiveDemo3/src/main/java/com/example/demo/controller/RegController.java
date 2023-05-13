package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class RegController {
	
	
	@GetMapping("/mono")
	public Mono<String> getMonoResult(){
		return  Mono.just("Result from mono");
	}

	@GetMapping("/flux")
	public Flux<String>  getFluxResult(){
		return Flux.fromIterable(List.of("sri","navin","nikhil")).log();
	}
}