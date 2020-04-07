package com.example.springboot.productb.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class bankCreditDto {

private String id;
	
	private String bank;
	
	private String typeOwner;
	
	private String productName;
	
	private String numberAccount;
	
	private String namOwner;
	
	private String  dni;

	private Double creditAmount;
	
	private Double balance;
	
	private Double consume;
	
	@JsonFormat(pattern = "yyyy-MM.dd")
	private Date JoinDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expirationDate;
	
	
	
	
}
