
package com.example.springboot.productb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.springboot.productb.model.bankProductType;

public interface IBankProductTypeRespository extends ReactiveMongoRepository<bankProductType, String> {

}
