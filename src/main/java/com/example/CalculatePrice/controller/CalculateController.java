package com.example.CalculatePrice.controller;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CalculatePrice.model.DishDTO;

@RestController
@Configuration
public class CalculateController {
	
	@PostMapping("/calculate")
	ResponseEntity<Double> calculateFare(@RequestBody List<DishDTO> dishes){
		
		double totalPrice = 0; //set total price = 0 
		
		//use for each to go through all dish in dishes
		for(DishDTO dish : dishes) {
			double dishPrices = getDishPrice(dish.getDish());
			totalPrice += dishPrices*dish.getQuantity();
		}
		
		return ResponseEntity.ok(totalPrice);
		
	};
	
	private double getDishPrice(String dishName) {
		
		switch(dishName.toUpperCase()) {
		case "PIZZA":
			return 12.99;
		case "BURGER":
			return 13.99;
		case "PASTA":
			return 10.99;
		case "SALAD":
			return 8.99;
		default:
		    throw new IllegalArgumentException("Invalid dish: " + dishName);
		}
		
	}
	
	
	
}
