package com.example.springboot.productb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.productb.model.bankProduct;
import com.example.springboot.productb.repository.IBankProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IBankProductServiceImpl implements IBankProductService{

	
	@Autowired
	private IBankProductRepository bankproductrepository;
	
	
	@Override
	public Mono<bankProduct> save(bankProduct bankproduct) {
		
		return this.bankproductrepository.save(bankproduct);
	}

	@Override
	public Mono<bankProduct> findBiId(String id) {
	
		return this.bankproductrepository.findById(id);
	}

	@Override
	public Mono<Void> delete(bankProduct  bankproduct) {
		
		return this.bankproductrepository.delete(bankproduct);
				
	}

	@Override
	public Mono<bankProduct> update(bankProduct bankproduct, String id) {
	
		return this.bankproductrepository.findById(id)
				.flatMap(b -> {
					bankproduct.setIdproduct(id);
					return save(bankproduct);
				}).switchIfEmpty(Mono.empty());
	}

	@Override
	public Flux<bankProduct> findAll() {
	
		return this.bankproductrepository.findAll();
	}

}
