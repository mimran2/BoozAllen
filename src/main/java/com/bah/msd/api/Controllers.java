package com.bah.msd.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.entities.Customer;
import com.bah.msd.entities.Event;
import com.bah.msd.entities.Registration;
import com.bah.msd.persistence.CustomerRepository;
import com.bah.msd.persistence.EventRepository;
import com.bah.msd.persistence.RegistrationRepository;

@RestController
@RequestMapping("/api")
public class Controllers {
	private final String JSON = "application/json";

	@Autowired
	private CustomerRepository CustomerRepository;
	@Autowired
	private EventRepository EventRepository;
	@Autowired
	private RegistrationRepository RegistrationRepository;

	@PostMapping(path = "/register", consumes = JSON, produces = JSON)
	@ResponseBody
	public String login() {
		return "hi";
	}

	@GetMapping(path = "/customers", produces = JSON)
	@ResponseBody
	public Iterable<Customer> getCustomers(HttpServletResponse response) {
		response.setHeader("Location", "api/customers");
		response.setStatus(HttpServletResponse.SC_OK);

		return CustomerRepository.findAll();
	}

	@GetMapping(path = "/events", produces = JSON)
	@ResponseBody
	public Iterable<Event> getEvents(HttpServletResponse response) {
		response.setHeader("Location", "api/events");
		response.setStatus(HttpServletResponse.SC_OK);

		return EventRepository.findAll();
	}

	@PutMapping(path = "/events/{id}", consumes = JSON, produces = JSON)
	@ResponseBody
	public Event createUpdateEvent(HttpServletResponse response, @PathVariable long id, @RequestBody Event requestEvent) {
		response.setHeader("Location", "api/events");
		response.setStatus(HttpServletResponse.SC_CREATED);

		Event event = EventRepository.save(requestEvent);

		return event;
	}
	
	@DeleteMapping(path = "/events/{id}", consumes = JSON, produces = JSON)
	@ResponseBody
	public String deleteEvent(HttpServletResponse response, @PathVariable long id) {
		response.setHeader("Location", "api/events");
		response.setStatus(HttpServletResponse.SC_OK);


		return "event deletion success";
	}
	
	@GetMapping(path = "/registrations", produces = JSON)
	@ResponseBody
	public Iterable<Registration> getRegistrations(HttpServletResponse response) {
		response.setHeader("Location", "api/registrations");
		response.setStatus(HttpServletResponse.SC_OK);

		return RegistrationRepository.findAll();
	}
}
