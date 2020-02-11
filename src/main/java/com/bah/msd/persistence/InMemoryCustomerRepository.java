package com.bah.msd.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bah.msd.entities.Customer;
@Component
public class InMemoryCustomerRepository implements CustomerRepository {
	public List<Customer> customerList = new ArrayList<>(
			Arrays.asList(new Customer("Harry", "harry@gmail.com", "harry")));

	@Override
	public Collection<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerList;
	}

}
