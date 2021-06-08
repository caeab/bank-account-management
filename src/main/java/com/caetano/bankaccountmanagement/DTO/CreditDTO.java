package com.caetano.bankaccountmanagement.DTO;

public class CreditDTO {

	private Long accountId;
	private Double amount;

	public CreditDTO() {
	}

	public CreditDTO(Long accountId, Double amount) {
		this.accountId = accountId;
		this.amount = amount;
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

}
