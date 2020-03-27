package com.example.springboot.productb.service;

import com.example.springboot.productb.model.bankProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankProductService {
	
	Mono<bankProduct> save(bankProduct bankproduct);
	Mono<bankProduct> findBiId(String id);
	Mono<Void> delete(bankProduct bankproduct);
	Mono<bankProduct> update(bankProduct bankproduct,String id);
	Flux<bankProduct> findAll();

}
