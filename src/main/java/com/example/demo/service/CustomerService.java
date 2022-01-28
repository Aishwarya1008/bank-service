package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Deposit;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DepositRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private DepositRepository depositRepository;
	
	public void addUser(Customer customer) {
		customerRepository.save(customer);
	}

	
}
