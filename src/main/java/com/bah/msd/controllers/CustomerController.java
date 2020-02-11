package com.bah.msd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.entities.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
	private final String JSON = "application/json";

	@GetMapping(path = "/customers", produces = JSON)
	public Customer getCustomers() {
	}
}
