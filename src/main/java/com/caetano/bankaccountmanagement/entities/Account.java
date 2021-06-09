package com.caetano.bankaccountmanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.caetano.bankaccountmanagement.DTO.AccountDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_accounts")
public class Account {

	@Id
	private Long identifier;
	private String name;
	private String description;
	private String status;
	private Double balance;

	@JsonIgnore
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transactions = new ArrayList<>();

	public Account() {
	}

	public Account(AccountDTO obj) {
		this.identifier = obj.getIdentifier();
		this.name = obj.getName();
		this.description = obj.getDescription();
		this.status = obj.getStatus();
	}

	public Account(Long identifier, String name, String description, String status, Double balance) {
		this.identifier = identifier;
		this.name = name;
		this.description = description;
		this.status = status;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void credit(Double amount) {
		this.balance += amount;
	}

	public void debit(Double amount) {
		this.balance -= amount;
	}

	public boolean canDebit(Double amount) {
		return (amount <= this.balance);
	}

}
