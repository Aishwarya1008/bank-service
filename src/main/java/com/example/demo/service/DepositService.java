package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Deposit;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DepositRepository;

@Service
public class DepositService {

	@Autowired
	private DepositRepository depositRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	public void addDeposit(Deposit deposit, Integer id) {
		
		Customer customer = customerRepository.findById(id).get();
		
		Double old_amt = customer.getDeposit().getAmt();
		Double final_amt = old_amt + deposit.getAmt();
		
		Deposit _deposit = customer.getDeposit();
		_deposit.setAmt(final_amt);
		depositRepository.save(_deposit);
		
		customer.setDeposit(_deposit);
		customerRepository.save(customer);
		
	}

}
