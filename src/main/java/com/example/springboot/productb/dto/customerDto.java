package com.example.springboot.productb.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class customerDto {

	@Id
	private String id;

	private String fullname;

	private String numDoc;
	
	private String address;
	
	private String bank;
	 
    private String type;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date joinAt;


	


	
}
