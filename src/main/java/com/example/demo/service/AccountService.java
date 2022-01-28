package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	public void addAccount(Account account) throws Exception {
		
		Integer customerId = Integer.parseInt(account.getCustomerId());
		
		Customer customer = customerRepository.findById(customerId).get();
		
		if(customer != null) {
			
			if(customer.getAccount() == null) {
				
				customer.setAccount(account);
				accountRepository.save(account);
				customerRepository.save(customer);
				
			} else {
				throw new Exception("customer already has an account");
			}
			
		} else {
			throw new Exception("customer with this id dosen't exists");
		}

	}
}
