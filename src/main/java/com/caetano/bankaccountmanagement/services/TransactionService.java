package com.caetano.bankaccountmanagement.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caetano.bankaccountmanagement.DTO.TransferRequestDTO;
import com.caetano.bankaccountmanagement.DTO.TransferResponseDTO;
import com.caetano.bankaccountmanagement.entities.Account;
import com.caetano.bankaccountmanagement.entities.ReceiverTransfer;
import com.caetano.bankaccountmanagement.entities.Transaction;
import com.caetano.bankaccountmanagement.entities.Transfer;
import com.caetano.bankaccountmanagement.repositories.TransactionRepository;
import com.caetano.bankaccountmanagement.repositories.TransferRepository;
import com.caetano.bankaccountmanagement.services.exceptions.BusinessException;
import com.caetano.bankaccountmanagement.services.exceptions.MissingRequiredParametersException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private TransferRepository transferRepository;

	@Autowired
	private AccountService accountService;

	public TransferResponseDTO makeTransfer(TransferRequestDTO entity) {

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
		ReceiverTransfer receiverTransfer = new ReceiverTransfer(receiverAccount, entity.getAmount(), Instant.now(), entity.getSenderId());
		transactionRepository.save(receiverTransfer);
		return new TransferResponseDTO(transactionRepository.save(transfer));

	}

	public List<TransferResponseDTO> findAllTransfer() {
		List<Transfer> list = transferRepository.findAll();
		return list.stream().map(x -> new TransferResponseDTO(x)).collect(Collectors.toList());
	}

	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

}
