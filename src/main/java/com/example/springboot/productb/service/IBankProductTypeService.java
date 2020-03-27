package com.example.springboot.productb.service;

import com.example.springboot.productb.model.bankProductType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankProductTypeService {

	Flux<bankProductType> findAll();
	Mono<bankProductType> findById(String id);
	Mono<bankProductType> save(bankProductType bankproducttype);
	Mono<bankProductType> update(bankProductType bankproducttype,String id);
	Mono<Void> delete(bankProductType bankproducttype);
	
}
