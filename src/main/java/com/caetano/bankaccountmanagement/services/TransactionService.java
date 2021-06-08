package com.caetano.bankaccountmanagement.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caetano.bankaccountmanagement.DTO.TransferDTO;
import com.caetano.bankaccountmanagement.entities.Account;
import com.caetano.bankaccountmanagement.entities.Transaction;
import com.caetano.bankaccountmanagement.entities.Transfer;
import com.caetano.bankaccountmanagement.repositories.TransactionRepository;
import com.caetano.bankaccountmanagement.services.exceptions.BusinessException;
import com.caetano.bankaccountmanagement.services.exceptions.MissingRequiredParametersException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountService accountService;

	public Transfer makeTransfer(TransferDTO entity) {

		if (entity.getAmount() == null) {
			throw new MissingRequiredParametersException("Amount required");
		}

		Account senderAccount = accountService.findById(entity.getSenderId());
		if (!senderAccount.canDebit(entity.getAmount())) {
			throw new BusinessException("Sender does not have enough balance");
		}

		Account receiverAccount = accountService.findById(entity.getReceiverId());

		senderAccount.debit(entity.getAmount());
		receiverAccount.credit(entity.getAmount());

		Transfer transfer = new Transfer(senderAccount, entity.getAmount(), Instant.now(), entity.getReceiverId());
		return transactionRepository.save(transfer);

	}

	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

}
