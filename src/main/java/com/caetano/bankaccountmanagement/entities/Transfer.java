package com.caetano.bankaccountmanagement.entities;

import java.util.Date;

/*
@Entity
@Table(name="tb_transfers")
@DiscriminatorValue("transfer")*/
public class Transfer extends Transaction {
	
	private Long receiverId;
	
	public Transfer() {
	}

	public Transfer(Account account, Double amount, Date date, Long receiver) {
		super(account, amount, date);
		this.receiverId = receiver;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
	


}
