package com.bah.msd.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@DeleteMapping(path = "/registrations/{id}")
	public ResponseEntity<?> deleteRegistrationById(@PathVariable long id) {
		try {
			RegistrationRepository.deleteById(id);
		}catch(IllegalArgumentException e) {
			return  ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	

}
