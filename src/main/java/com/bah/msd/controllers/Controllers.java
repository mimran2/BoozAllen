package com.bah.msd.controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.entities.Customer;
import com.bah.msd.entities.Event;
import com.bah.msd.persistence.CustomerRepository;
import com.bah.msd.persistence.EventRepository;

@RestController
@RequestMapping("/api")
public class Controllers {
	private final String JSON = "application/json";
	
	@Autowired
	private CustomerRepository CustomerRepository;
	@Autowired
	private EventRepository EventRepository;

	@GetMapping(path = "/customers", produces = JSON)
	public Collection<Customer> getCustomers(HttpServletResponse response ) {
		response.setHeader("Location", "api/customers");
		response.setStatus(HttpServletResponse.SC_OK);
		 
		return CustomerRepository.findAll();
	}
	
	@GetMapping(path = "/events", produces = JSON)
	public Collection<Event> getEvents(HttpServletResponse response ) {
		response.setHeader("Location", "api/events");
		response.setStatus(HttpServletResponse.SC_OK);
		 
		return EventRepository.findAll();
	}
}
