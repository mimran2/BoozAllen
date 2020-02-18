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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.entities.Customer;
import com.bah.msd.entities.Event;
import com.bah.msd.persistence.EventRepository;

@RestController
@RequestMapping("/api")
public class EventsAPI {
	@Autowired
	private EventRepository EventRepository;
	
	private final String JSON = "application/json";

	
	@GetMapping(path = "/events", produces = JSON)
	public Iterable<Event> getAll(HttpServletResponse response) {
		return EventRepository.findAll();
	}
	
	@PostMapping("/events")
	public ResponseEntity<?> postEvent(@RequestBody Event event) {
		if (event.getCode() == null || event.getTitle() == null || event.getDescription() == null) {
			return ResponseEntity.badRequest().build();
		}
		EventRepository.save(event);

		return ResponseEntity.ok().build();
	}
	
	@PutMapping(path = "/events/{id}")
	public ResponseEntity<?> createUpdateEvent(@PathVariable long id, 
			@RequestBody Event requestEvent) {
		if(requestEvent.getCode()== null || requestEvent.getDescription() == null
			||requestEvent.getTitle() == null) {
			return ResponseEntity.badRequest().build();
		}
		requestEvent = EventRepository.save(requestEvent);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/events/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteEvent(@PathVariable long id) {
		try {
			EventRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
		}

}
