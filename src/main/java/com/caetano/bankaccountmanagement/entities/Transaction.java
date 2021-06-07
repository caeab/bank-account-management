package com.caetano.bankaccountmanagement.entities;

import java.time.Instant;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_transactions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="transaction_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@ManyToOne
	private Account account;
	private Double amount;
	private Instant timestamp;
	
	
	public Transaction() {
	}



	public Transaction(Account account, Double amount, Instant timestamp) {
		this.account = account;
		this.amount = amount;
		this.timestamp = timestamp;
	}




	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
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

	public Long getId() {
		return id;
	}
	
	

}
