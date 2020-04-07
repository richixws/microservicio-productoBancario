package com.example.springboot.productb.client;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.springboot.productb.dto.customerDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class customerCust {

	@Autowired
	@Qualifier("customer")
	private WebClient client;
	
	
	public Flux<customerDto> fillAllCustomer(){
	   
		return client.get().uri("/findAll")
				     .retrieve()
				     .bodyToFlux(customerDto.class);
	}
	
	public Mono<customerDto> createById(String id){
		
		return client.get().uri("/findById/{id}",Collections.singletonMap("id", id))
				           .retrieve()
				           .bodyToMono(customerDto.class);	
		
	}
	
	public Mono<customerDto> updateBank(String bank , String id){
		
		return client.put().uri("/updateBank/{id}",Collections.singletonMap("id", id))
				           .accept(MediaType.APPLICATION_JSON)
				           .contentType(MediaType.APPLICATION_JSON)
				           .bodyValue(bank)
				           .retrieve()
				           .bodyToMono(customerDto.class);
				
	}
	
	public Mono<customerDto> save(customerDto cusDto){
		return client.post().uri("/create")
				            .accept(MediaType.APPLICATION_JSON)
				            .contentType(MediaType.APPLICATION_JSON)
				            .body(BodyInserters.fromValue(cusDto))
				            .retrieve()
				            .bodyToMono(customerDto.class);
	}
	
}










