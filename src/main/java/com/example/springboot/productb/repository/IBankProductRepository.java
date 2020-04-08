package com.example.springboot.productb.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.springboot.productb.model.bankProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankProductRepository extends ReactiveMongoRepository<bankProduct, String> {

    public Mono<bankProduct> findByNumDoc(String numDoc);
	
	@Query("{'clientType' : ?0}")
	public Flux<bankProduct> findByType(String clientType);
	
	//Buscar por banco
	@Query("{'bank' : ?0}")
	public Flux<bankProduct> findByBank(String bank);
	
	@Query("{'numAccount' : ?0}")
	public Mono<bankProduct> findByNumAccount(String numAccount);
}


