package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "syneproduct")
public class Product {

	
	@Id
	private int id;
}
