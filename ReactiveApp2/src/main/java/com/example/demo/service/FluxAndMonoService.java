package com.example.demo.service;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoService {

	
	//create flux
	public Flux<String> employeeFlux(){
		
		return Flux.fromIterable(List.of("sri","navin","nikhil")).log();
	
	}
	
	//create mono
	public Mono<String> employeeMono(){
		return Mono.just("john").log();
	}
	
	//create map
	public Flux<String> employeeFluxMap(){
			return Flux.fromIterable(List.of("srini","navin","nikhil")).map(String::toUpperCase).log();
	}
	
	//create filter
	public Flux<String> employeeFluxFilter(int number){
		return Flux.fromIterable(List.of("sri","nav","nikhil")).filter(emp -> emp.length() < number).log();
	}
	
	//filter+map
	public Flux<String> employeeFluxFilterMap(int number){
		return Flux.fromIterable(List.of("sri","nav","nikhil"))
				.filter(emp -> emp.length() < number)
				.map(String::toUpperCase).log();
	}
	
	
	
	    //flatMap
		public Flux<String> employeeFluxFlatMap(){
			return Flux.fromIterable(List.of("sni","navin","nikhil"))
				.flatMap(emp -> Flux.just(emp.split(""))).log();
		}
	

	public static void main(String[] args) {
		
		FluxAndMonoService   fluxAndMonoService = new FluxAndMonoService();

		//fluxAndMonoService.employeeFlux().subscribe(emp -> System.out.println("flux:"+emp));
		
		//fluxAndMonoService.employeeMono().subscribe(emp ->  System.out.println("Mono :"+emp));
		
		//fluxAndMonoService.employeeFluxMap().subscribe(emp -> System.out.println("Map:"+emp));
		
		//fluxAndMonoService.employeeFluxFilter(4).subscribe(emp -> System.out.println("Filter:"+emp));
		
		//fluxAndMonoService.employeeFluxFilterMap(4).subscribe(emp -> System.out.println("Filter and Map:"+emp));
		
		fluxAndMonoService.employeeFluxFlatMap().subscribe(emp -> System.out.println("Falt Map:"+emp));
		
	}

}
