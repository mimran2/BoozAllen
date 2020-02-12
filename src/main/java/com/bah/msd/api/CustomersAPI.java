package com.bah.msd.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.entities.Customer;
import com.bah.msd.persistence.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
public class CustomersAPI {
	@Autowired
	private CustomerRepository CustomerRepository;

	@GetMapping
	public Iterable<Customer> getCustomers(HttpServletResponse response) {
		response.setHeader("Location", "api/customers");
		response.setStatus(HttpServletResponse.SC_OK);

		return CustomerRepository.findAll();
	}

	@PostMapping("/byname")
	public Customer lookupCustomerByName(HttpServletResponse response, @RequestBody String name) {
		response.setHeader("Location", "api/events");
		response.setStatus(HttpServletResponse.SC_FOUND);
		Customer customer = CustomerRepository.findByName(name).orElse(null);

		return customer;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer customer, @PathVariable long id) {
		if (customer.getId() != id || customer.getName() == null || customer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		CustomerRepository.save(customer);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable long id) {
		Customer customer = CustomerRepository.findById(id).orElse(null);
		if (customer == null) {
			return ResponseEntity.badRequest().build();
		}
		CustomerRepository.delete(customer);
		return ResponseEntity.ok().build();
	}

}
