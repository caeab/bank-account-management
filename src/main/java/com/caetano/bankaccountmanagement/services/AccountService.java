package com.caetano.bankaccountmanagement.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.caetano.bankaccountmanagement.DTO.AccountBalanceDTO;
import com.caetano.bankaccountmanagement.DTO.AccountDTO;
import com.caetano.bankaccountmanagement.DTO.CreditDTO;
import com.caetano.bankaccountmanagement.entities.Account;
import com.caetano.bankaccountmanagement.entities.Transaction;
import com.caetano.bankaccountmanagement.repositories.AccountRepository;
import com.caetano.bankaccountmanagement.services.exceptions.BusinessException;
import com.caetano.bankaccountmanagement.services.exceptions.EntityAlreadyExistsException;
import com.caetano.bankaccountmanagement.services.exceptions.MissingRequiredParametersException;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionService transactionService;

	public AccountService() {
	}

	public List<AccountDTO> findAll() {
		List<Account> list = accountRepository.findAll();
		return list.stream().map(x -> new AccountDTO(x)).collect(Collectors.toList());
	}

	public Account findById(Long id) {
		if (id == null) {
			throw new MissingRequiredParametersException("Identifier required");
		}
		return accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
	}

	public AccountBalanceDTO getBalance(Long id) {
		return new AccountBalanceDTO(findById(id));
	}

	public void delete(Long id) {
		Account account = findById(id);
		accountRepository.delete(account);
	}

	public AccountDTO insert(AccountDTO entity) {
		if ((entity.getIdentifier() == null) || (entity.getDescription() == null) || (entity.getName() == null)
				|| (entity.getStatus() == null)) {
			throw new MissingRequiredParametersException("Missing required parameters");
		}
		if (accountRepository.existsById(entity.getIdentifier())) {
			throw new EntityAlreadyExistsException("Identifier  " + entity.getIdentifier() + " already exists");
		}
		Account account = new Account(entity);
		account.setBalance(0.0);
		return new AccountDTO(accountRepository.save(account));
	}

	public AccountDTO update(long id, @RequestBody AccountDTO entity) {

		Account account = findById(id);

		account.setName(entity.getName() != null ? entity.getName() : account.getName());
		account.setDescription(entity.getDescription() != null ? entity.getDescription() : account.getDescription());
		account.setStatus(entity.getStatus() != null ? entity.getStatus() : account.getStatus());
		return new AccountDTO(accountRepository.save(account));
	}

	public AccountBalanceDTO credit(@RequestBody CreditDTO entity) {
		Account account = findById(entity.getAccountId());

		if (entity.getAmount() == null) {
			throw new MissingRequiredParametersException("Amount required");
		}

		if (entity.getAmount() <= 0) {
			throw new BusinessException("Amount must be a positive value");
		}
		account.credit(entity.getAmount());
		transactionService.saveCredit(account, entity.getAmount());
		return new AccountBalanceDTO(accountRepository.save(account));
	}

	public Page<Transaction> getStatement(Long id, Pageable pageable) {

		Account account = findById(id);
		
		return transactionService.getStatement(account, pageable);
	} 

}
