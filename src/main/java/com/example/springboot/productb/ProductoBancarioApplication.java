package com.example.springboot.productb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.springboot.productb.model.bankProduct;
import com.example.springboot.productb.model.bankProductType;
import com.example.springboot.productb.repository.IBankProductRepository;
import com.example.springboot.productb.repository.IBankProductTypeRespository;
import com.google.common.eventbus.Subscribe;

import reactor.core.publisher.Flux;

@EnableEurekaClient
@SpringBootApplication
public class ProductoBancarioApplication implements CommandLineRunner{

	
	@Autowired
	private IBankProductRepository bankProductRepository;
	
	@Autowired
	private IBankProductTypeRespository bankProductTypeRespository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProductoBancarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	//registro de producto bancario
		bankProductType banproduct1=new bankProductType("ahorro");
		bankProductType banproduct2=new bankProductType("cuentas corrientes");
		bankProductType banproduct3=new bankProductType("plazo fijo");
		
	   Flux.just(banproduct1,banproduct2,banproduct3)
	   .flatMap(tip -> bankProductTypeRespository.save(tip))
	   .thenMany(Flux.just(new bankProduct("cuenta", 1, 1.08, banproduct1),
			               new bankProduct("cuenta", 1, 1.08, banproduct2),
			               new bankProduct("cuenta", 2, 1.08, banproduct3))
	    .flatMap(bankproduct -> bankProductRepository.save(bankproduct))).subscribe();
	  
	}
}
