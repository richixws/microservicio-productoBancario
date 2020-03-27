package com.example.springboot.productb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.productb.model.bankProductType;
import com.example.springboot.productb.service.IBankProductTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("productotipo")
@Api(value = "control tipo producto bancario")
public class bankProductTypeController {

	@Autowired
	private IBankProductTypeService bankProductTypeService;
	
	
	@GetMapping("/list")
	@ApiOperation("listar tipo producto bancario")
	private Flux<bankProductType> findAll(){
		return this.bankProductTypeService.findAll();
	}
     
    @GetMapping("/list/{id}")
    @ApiOperation("listar por codigo de tipo de bancario")
	private Mono<bankProductType> findById(@PathVariable String id){
	
		return this.bankProductTypeService.findById(id);
	}
	
	@PostMapping("/save")
	@ApiOperation("guardar tipo de producto bancario")
	private Mono<bankProductType> save(@RequestBody bankProductType productType){
		return this.bankProductTypeService.save(productType);
	}
	
	@PutMapping("/{id}")
	@ApiOperation("actualizar tipo producto bancario")
	private Mono<bankProductType> Update(@RequestBody bankProductType productType, @PathVariable String id){
		return this.bankProductTypeService.update(productType, id);
	}
	
	@DeleteMapping("/{id}")
	
	private Mono<Void> delete(@RequestBody bankProductType productType){
	    return this.bankProductTypeService.delete(productType);	
	}
}
