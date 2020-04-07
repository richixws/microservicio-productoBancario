package com.example.springboot.productb.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.springboot.productb.dto.bankCreditDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class creditCustomer {

	@Autowired
	@Qualifier("creditproduct")
	private WebClient client;
	
	public Flux<bankCreditDto> findAllProducts(){
		
		return client.get().uri("/findAll").retrieve().bodyToFlux(bankCreditDto.class);
	}
	
	public Mono<bankCreditDto> findById(String id){
		
		return client.get().uri("/findById/{id}",Collections.singletonMap("id", id))
				           .retrieve()
				           .bodyToMono(bankCreditDto.class);
		
	}
	
	//	METODO CLIENTE PARA DEPOSITAR EN LA CUENTA CREDITO
	
	public Mono<bankCreditDto> depositC(Double amount,String numberAccount){
		
		Map<String, String> patch=new HashMap<String,String>();
		
		
		patch.put("amount", Double.toString(amount));
		patch.put("numberAccount", numberAccount);
		
		return client.put().uri("/depositC/{amount}/{numberAccount}",patch)
				     .accept(MediaType.APPLICATION_JSON)
				     .contentType(MediaType.APPLICATION_JSON)
				     .retrieve()
				     .bodyToMono(bankCreditDto.class);
	}
	
	// METODO CLIENTE PARA RETIRAR EN LA CUENTA CREDITO
	
	public Mono<bankCreditDto> retiroC(Double amount,String numberAccount){
		
		Map<String, String> path=new HashMap<String,String>();
		
		path.put("amount", Double.toString(amount));
		path.put("numberAccount", numberAccount);
		
		return client.put().uri("/retiroC/{amount}/{numberAccount}",path)
				           .accept(MediaType.APPLICATION_JSON)
				           .contentType(MediaType.APPLICATION_JSON)
				           .retrieve()
				           .bodyToMono(bankCreditDto.class);
				           		
	}
	
	public Mono<bankCreditDto> save(bankCreditDto dto){
		
		return client.post().uri("/create")
				            .accept(MediaType.APPLICATION_JSON)
				            .contentType(MediaType.APPLICATION_JSON)
				            .body(BodyInserters.fromValue(dto))
				            .retrieve()
				            .bodyToMono(bankCreditDto.class);
		
	}
	
	
}
