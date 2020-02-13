package com.bah.msd.persistence;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{ 
	public Customer findCustomerByName(String name);
	public Customer findCustomerById(long id);
}
