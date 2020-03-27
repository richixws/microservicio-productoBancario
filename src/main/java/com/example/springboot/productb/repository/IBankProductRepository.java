package com.example.springboot.productb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.springboot.productb.model.bankProduct;

public interface IBankProductRepository extends ReactiveMongoRepository<bankProduct, String> {

}


