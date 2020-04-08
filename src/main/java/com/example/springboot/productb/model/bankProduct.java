package com.example.springboot.productb.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Document(collection = "bankingProduct")
public class bankProduct {
	@Id
	private String id;
	
	@NotEmpty(message = "El campo banco no puede estar en blanco")
	private String bank;
	
	private String productName;
	
	private String clientType;
	
	private String numAccount;
	
	@NotEmpty(message = "El campo nameOwner no puede estar en blanco")
	private String nameOwner;
	
	private String numDoc;
	
	private Double amount;
	
	private Double amountAvailable;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date jointAt;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updateAt;

	
	
	
}
