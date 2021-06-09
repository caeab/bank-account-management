package com.caetano.bankaccountmanagement.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caetano.bankaccountmanagement.DTO.AccountBalanceDTO;
import com.caetano.bankaccountmanagement.DTO.BillPaymentDTO;
import com.caetano.bankaccountmanagement.DTO.TransferRequestDTO;
import com.caetano.bankaccountmanagement.DTO.TransferResponseDTO;
import com.caetano.bankaccountmanagement.entities.Account;
import com.caetano.bankaccountmanagement.entities.BillPayment;
import com.caetano.bankaccountmanagement.entities.Credit;
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
		ReceiverTransfer receiverTransfer = new ReceiverTransfer(receiverAccount, entity.getAmount(), Instant.now(),
				entity.getSenderId());
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

	public void saveCredit(Account account, Double amount) {
		Credit credit = new Credit(account, amount, Instant.now());
		transactionRepository.save(credit);
	}

	public AccountBalanceDTO payBill(BillPaymentDTO entity) {

		if ((entity.getAmount() == null) || (entity.getBarcode() == null) || (entity.getExpirationDate() == null)) {
			throw new MissingRequiredParametersException("Missing required parameters");
		}

		Account account = accountService.findById(entity.getPayerID());
		if (!account.canDebit(entity.getAmount())) {
			throw new BusinessException("Sender does not have enough balance");
		}

		account.debit(entity.getAmount());
		BillPayment billPayment = new BillPayment(account, entity.getAmount(), Instant.now(), entity.getBarcode(), entity.getExpirationDate());
		transactionRepository.save(billPayment);
		return new AccountBalanceDTO(account);
	}

}
