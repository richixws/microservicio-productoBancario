package com.example.springboot.productb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "tipocuentabancario")
public class bankProductType {

	@Id
	private String idProductType;
	
	private String descripcion;

	public bankProductType(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public String getIdProductType() {
		return idProductType;
	}

	public void setIdProductType(String idProductType) {
		this.idProductType = idProductType;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
