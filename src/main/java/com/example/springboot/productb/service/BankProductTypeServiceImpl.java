package com.example.springboot.productb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.productb.model.bankProductType;
import com.example.springboot.productb.repository.IBankProductTypeRespository;
import com.netflix.discovery.converters.Auto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankProductTypeServiceImpl implements IBankProductTypeService {


	@Autowired
	private IBankProductTypeRespository bankproducttyperepository;
	
	@Override
	public Flux<bankProductType> findAll() {
		// TODO Auto-generated method stub
		return this.bankproducttyperepository.findAll();
	}

	@Override
	public Mono<bankProductType> findById(String id) {
		// TODO Auto-generated method stub
		return this.bankproducttyperepository.findById(id);
	}

	@Override
	public Mono<bankProductType> save(bankProductType bankproducttype) {
		// TODO Auto-generated method stub
		return this.bankproducttyperepository.save(bankproducttype);
	}

	@Override
	public Mono<bankProductType> update(bankProductType bankproducttype, String id) {
		// TODO Auto-generated method stub
		return this.bankproducttyperepository.findById(id)
				.flatMap(b -> {
					bankproducttype.setIdProductType(id);
					return save(bankproducttype);
				});
	}

	@Override
	public Mono<Void> delete(bankProductType bankproducttype) {
		// TODO Auto-generated method stub
		return this.bankproducttyperepository.delete(bankproducttype);
	}

}
