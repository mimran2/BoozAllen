package com.bah.msd.persistence;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{ 
}
