package com.bah.msd.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bah.msd.entities.Customer;
import com.bah.msd.entities.Event;
import com.bah.msd.entities.Registration;

@Component
public class InMemoryRegistrationRepository implements RegistrationRepository{
	public List<Registration> registrationsList = new ArrayList<>(
			Arrays.asList(new Registration(1,new Customer(1, "Harry", "harry@gmail.com", "harry"),
					new Event(1, "CMSCM130", "Hiring Event", "Find your future job"), 
					new Date(), "This is test")));

	@Override
	public Collection<Registration> findAll() {
		// TODO Auto-generated method stub
		return registrationsList;
	}

}
