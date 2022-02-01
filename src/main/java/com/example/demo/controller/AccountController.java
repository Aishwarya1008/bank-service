package com.example.demo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/addAccount")
	@Transactional
	@ResponseStatus(code = HttpStatus.CREATED)
	void addAccount(@RequestBody @Valid Account account) throws Exception {
		accountService.addAccount(account);
	}
	
	@GetMapping("/{id}/balance")
	public ResponseEntity<String> balanceEnquiry(@PathVariable("id") Integer id) {
		
		Account account = accountService.balanceEnquiry(id);

		if(account != null) {
			return new ResponseEntity<>(String.valueOf(account.getInitialDeposit()), HttpStatus.OK);
			
		}

		return new ResponseEntity<>("This accound Id dosen't exists", HttpStatus.BAD_REQUEST);
	}
}
