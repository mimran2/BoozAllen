package com.bah.msd.persistence;

import java.util.Collection;

import com.bah.msd.entities.Customer;

public interface CustomerRepository {
	public Collection<Customer> findAll();
}
