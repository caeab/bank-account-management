package com.caetano.bankaccountmanagement.entities;

import java.util.Date;
/*
@Entity
@Table(name="tb_transactions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="transaction_type", discriminatorType = DiscriminatorType.STRING)*/
public abstract class Transaction {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	//@ManyToOne
	private Account account;
	private Double amount;
	private Date date;
	
	
	public Transaction() {
	}


	public Transaction(Account account, Double amount, Date date) {
		this.account = account;
		this.amount = amount;
		this.date = date;
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


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}
	
	

}
