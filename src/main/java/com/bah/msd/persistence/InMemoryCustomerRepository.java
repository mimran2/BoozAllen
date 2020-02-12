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
			Arrays.asList(new Customer(1, "Harry", "harry@gmail.com", "harry"),
					new Customer(2, "Stark", "stark@gmail.com", "stark"),
					new Customer(3, "Tom", "tom@gmail.com", "tom"),
					new Customer(4, "Vane", "vayne@gmail.com", "vayne")));

	@Override
	public Collection<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerList;
	}

}
