package com.bah.msd.api;

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

import com.bah.msd.entities.Registration;
import com.bah.msd.persistence.RegistrationRepository;

@RestController
@RequestMapping("/api")
public class RegistrationsAPI {

	@Autowired
	private RegistrationRepository RegistrationRepository;

	@GetMapping(path = "/registrations")
	public Iterable<Registration> getRegistrations() {
		return RegistrationRepository.findAll();
	}
	
	@PostMapping("/registrations")
	public ResponseEntity<?> postRegistration(@RequestBody Registration registration) {
		if (registration.getNotes() == null || registration.getRegistration_date() == null) {
			return ResponseEntity.badRequest().build();
		}
		RegistrationRepository.save(registration);

		return ResponseEntity.ok().build();
	}

	@PutMapping(path = "/registrations/{id}")
	public ResponseEntity<?> createUpdateRegistration(@PathVariable long id, @RequestBody Registration requestEvent) {
		if (requestEvent.getNotes() == null || requestEvent.getRegistration_date() == null) {
			return ResponseEntity.badRequest().build();
		}
		requestEvent = RegistrationRepository.save(requestEvent);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping(path = "/registrations/{id}")
	public ResponseEntity<?> deleteRegistrationById(@PathVariable long id) {
		try {
			RegistrationRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

}
