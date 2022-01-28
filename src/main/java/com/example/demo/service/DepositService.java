package com.example.demo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Deposit;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DepositRepository;

@Service
public class DepositService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private DepositRepository depositRepository;
	
	public void addDeposit(Deposit deposit) throws Exception {

		Integer accountNumber = Integer.parseInt(deposit.getAccNumber());
		
		Account account = accountRepository.findById(accountNumber).get();
		
		if(account != null) {
			
			Double old_amt =  account.getInitialDeposit();
			Double final_amt = old_amt + deposit.getAmt();
			account.setInitialDeposit(final_amt);
			account.getDeposits().add(deposit);
			accountRepository.save(account);
			
		} else {
			throw new Exception();
		}
		
	}

}
