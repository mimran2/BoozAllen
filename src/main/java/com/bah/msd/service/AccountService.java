package com.bah.msd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bah.msd.persistence.CustomerRepository;

@Service
public class AccountService {
	private CustomerRepository customerRepository;
	
	@Autowired
	public AccountService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	

}
