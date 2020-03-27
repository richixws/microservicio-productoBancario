package com.example.springboot.productb.model;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Document(collection = "cuentabancario")
public class bankProduct {

	@Id
	private String idproduct;
	
	private String descripcion;
	
	private Integer numMaxDeposit;
	
	private Double comision;
	
	@Valid
	private bankProductType typeProduct;
	

	public bankProduct(String descripcion, Integer numMaxDeposit, Double comision, @Valid bankProductType typeProduct) {
		super();
		this.descripcion = descripcion;
		this.numMaxDeposit = numMaxDeposit;
		this.comision = comision;
		this.typeProduct = typeProduct;
	}

	
	
	
}
