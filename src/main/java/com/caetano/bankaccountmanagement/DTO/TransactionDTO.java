package com.caetano.bankaccountmanagement.DTO;

import java.time.Instant;

import com.caetano.bankaccountmanagement.entities.Transaction;

public class TransactionDTO {

	private Long accountId;
	private Double amount;
	private Instant timestamp;
	
	public TransactionDTO() {
	}

	public TransactionDTO(Transaction obj) {
		this.accountId = obj.getAccount().getIdentifier();
		this.amount = obj.getAmount();
		this.timestamp = obj.getTimestamp();
	}

	public TransactionDTO(Long accountId, Double amount, Instant timestamp) {
		this.accountId = accountId;
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
