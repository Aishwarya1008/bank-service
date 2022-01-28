package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{

}
