package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "syneproduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	
	@Id
	private int id;
	
	private String productName;
	private double ratePerUnit;
	
}
