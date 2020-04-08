package com.example.springboot.productb;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import com.example.springboot.productb.model.bankProduct;
//import com.example.springboot.productb.model.bankProductType;
//import com.example.springboot.productb.repository.IBankProductRepository;
//import com.example.springboot.productb.repository.IBankProductTypeRespository;
//import com.google.common.eventbus.Subscribe;

//import reactor.core.publisher.Flux;

@EnableEurekaClient
@SpringBootApplication
public class ProductoBancarioApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ProductoBancarioApplication.class, args);
	}

	
}
