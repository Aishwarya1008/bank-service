package com.example.demo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Deposit;
import com.example.demo.service.DepositService;

@RestController
public class DepositController {
	
	@Autowired
	private DepositService depositService;
	
	@PostMapping("/{id}/deposit")
	@Transactional
	@ResponseStatus(code = HttpStatus.CREATED)
	void addDeposit(@RequestBody @Valid Deposit deposit, @PathVariable("id") Integer id) {
		depositService.addDeposit(deposit, id);
	}

}
