package com.example.springboot.productb.service;

import com.example.springboot.productb.dto.bankCreditDto;
import com.example.springboot.productb.dto.customerDto;
import com.example.springboot.productb.model.bankProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankProductService {
	
public Flux<bankProduct> findAll();
	
	public Mono<bankProduct> findById(String id);
	
	public Mono<bankProduct> save(bankProduct bp);
	
	public Mono<bankProduct> update(bankProduct bp, String id);
	
	public Mono<Void> delete(bankProduct bp);
	
	/*
	 * Métodos propios
	 */
	

	public Mono<bankProduct> findByNumDoc(String numDoc);
	
	public Flux<bankProduct> findByType(String clientType);
	
	public Flux<bankProduct> findByBank(String bank);
	
	public Mono<bankProduct> findByNumAccount(String numAccount);
	
	public Mono<bankProduct> depositB(Double amount, String numAccount); 
	
	public Mono<bankProduct> retiroB(Double amount, String numAccount);
	
	/*
	 * Métodos del webClient Customer
	 * 
	 */
	

	
	public Flux<customerDto> findAllClients();
	
	public Mono<customerDto> createById(String id);
	
	public Mono<customerDto> updateBank(String bank, String id);
	
	/*
	 * Método del webClient Crédito
	 * 
	 */
	
	public Mono<bankCreditDto> depositC(Double amount, String numAccountC, String numAccountB);
	
	public Mono<bankCreditDto> retiroC(Double amount, String numAccountC, String numAccountB);
}
