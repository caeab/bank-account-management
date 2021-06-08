package com.caetano.bankaccountmanagement.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.caetano.bankaccountmanagement.DTO.AccountDTO;
import com.caetano.bankaccountmanagement.DTO.TransferDTO;
import com.caetano.bankaccountmanagement.entities.Account;
import com.caetano.bankaccountmanagement.repositories.AccountRepository;
import com.caetano.bankaccountmanagement.services.exceptions.BusinessException;
import com.caetano.bankaccountmanagement.services.exceptions.EntityAlreadyExistsException;
import com.caetano.bankaccountmanagement.services.exceptions.MissingRequiredParametersException;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public AccountService() {
	}

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account findById(Long id) {
		if (id == null) {
			throw new MissingRequiredParametersException("Identifier required");
		}
		return accountRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Id not found " + id));
	}

	public Double getBalance(Long id) {
		Account account = findById(id);
		return account.getBalance();
	}

	public void delete(Long id) {
		Account account = findById(id);
		accountRepository.delete(account);
	}

	public Account insert(AccountDTO entity) {
		if (entity.getIdentifier() == null) {
			throw new MissingRequiredParametersException("Identifier required");
		}
		if (accountRepository.existsById(entity.getIdentifier())) {
			throw new EntityAlreadyExistsException("Identifier  " + entity.getIdentifier() + " already exists");
		}
		Account account = new Account(entity);
		account.setBalance(0.0);
		return accountRepository.save(account);
	}

	public Account update(long id, @RequestBody Account entity) {

		Account account = findById(id);

		account.setName(entity.getName() != null ? entity.getName() : account.getName());
		account.setDescription(entity.getDescription() != null ? entity.getDescription() : account.getDescription());
		account.setStatus(entity.getStatus() != null ? entity.getStatus() : account.getStatus());
		return accountRepository.save(account);
	}

	public Account credit(long id, @RequestBody TransferDTO entity) {
		Account account = findById(id);
		
		if (entity.getAmount() == null) {
			throw new MissingRequiredParametersException("Amount required");
		}

		if (entity.getAmount() <= 0) {
			throw new BusinessException("Amount must be a positive value");
		}
		account.credit(entity.getAmount());
		return accountRepository.save(account);
	}

}
