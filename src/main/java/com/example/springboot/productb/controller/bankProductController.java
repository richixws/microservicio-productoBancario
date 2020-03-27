package com.example.springboot.productb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.productb.model.bankProduct;
import com.example.springboot.productb.service.IBankProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productobancario")
@Api(value = "sistema control producto bancario")
public class bankProductController {

	@Autowired
	private IBankProductService bankProductService;
	
	@ApiOperation(value = "listado producto bancario")
	@GetMapping("/list")
	private Flux<bankProduct> findAll(){
		
		return this.bankProductService.findAll();
	}
	
	@ApiOperation(value = "listado por codigo")
	@GetMapping("/list/{id}")
	private Mono<bankProduct> findById(String id){
		return this.bankProductService.findBiId(id);
	}
	
	@ApiOperation(value = "guardar producto bancario")
	@PostMapping("/save")
	private Mono<bankProduct> save(@RequestBody bankProduct bankproduct){
		
	  return this.bankProductService.save(bankproduct);
		
	}
	
	@ApiOperation(value = "actualizar producto bancario")
	@PutMapping("/{id}")
	private Mono<bankProduct> update(@PathVariable String id,@RequestBody bankProduct bankproduct){
		
		return this.bankProductService.update(bankproduct, id);
	}
	
	@ApiOperation(value = "eliminar producto bancario")
	@DeleteMapping("/{id}")
	private Mono<Void> delete(@RequestBody bankProduct bankproduct){
		return this.bankProductService.delete(bankproduct);
	}
	
}
