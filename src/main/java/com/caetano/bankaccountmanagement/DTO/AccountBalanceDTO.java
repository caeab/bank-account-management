package com.caetano.bankaccountmanagement.DTO;

import com.caetano.bankaccountmanagement.entities.Account;

public class AccountBalanceDTO {	

	private Long identifier;
	private String name;
	private Double balance;
	

	public AccountBalanceDTO() {
	}

	public AccountBalanceDTO(Account entity) {
		this.identifier = entity.getIdentifier();
		this.name = entity.getName();
		this.balance = entity.getBalance();		
	}
	
	public AccountBalanceDTO(Long identifier, String name, Double balance) {
		this.identifier = identifier;
		this.name = name;
		this.balance = balance;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
