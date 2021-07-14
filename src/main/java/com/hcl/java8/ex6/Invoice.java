package com.hcl.java8.ex6;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Invoice {

	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;

}
