package com.caetano.bankaccountmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.caetano.bankaccountmanagement.DTO.AccountDTO;
import com.caetano.bankaccountmanagement.entities.Account;
import com.caetano.bankaccountmanagement.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public AccountService() {
	}
	
	public List<Account> findAll(){
		return accountRepository.findAll();
	}

	public Account findById(Long id) {
		return accountRepository.findById(id).get();
	}

	public Double getBalance(Long id) {
		Account account = accountRepository.findById(id).get();
		return account.getBalance();
	}
	
	public void delete(Long id) {
		accountRepository.deleteById(id);
	}
	
	public Account insert(AccountDTO entity) {
		Account account = new Account(entity);
		account.setBalance(0.0);
		return accountRepository.save(account);
	}
	
	public Account update(long id, @RequestBody Account entity) {
		
		Account account = accountRepository.findById(id).get();
		 
		account.setName(entity.getName() != null? entity.getName() : account.getName());
		account.setDescription(entity.getDescription() != null? entity.getDescription() : account.getDescription());
		account.setStatus(entity.getStatus() != null? entity.getStatus() : account.getStatus());
		return accountRepository.save(account);
	}
	
	public Account credit(long id, @RequestBody Account entity) {
		
		Account account = accountRepository.findById(id).get();		 
		account.setBalance(account.getBalance() + entity.getBalance());
		return accountRepository.save(account);
	}

}
