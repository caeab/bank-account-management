package com.caetano.bankaccountmanagement.services;

import java.util.List;

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
	
	public void delete(Long id) {
		accountRepository.deleteById(id);
	}
	
	public Account insert(AccountDTO entity) {
		Account account = new Account(entity);
		return accountRepository.save(account);
	}
	
	public Account update(long id, @RequestBody Account entity) {
		
		Account account = accountRepository.findById(id).get();

		account.setName(entity.getName());
		account.setDescription(entity.getDescription());
		account.setStatus(entity.getStatus());
		return accountRepository.save(account);
	}

}
