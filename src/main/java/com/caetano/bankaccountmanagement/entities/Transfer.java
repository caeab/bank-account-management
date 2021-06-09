package com.caetano.bankaccountmanagement.entities;

import java.time.Instant;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("transfer")
public class Transfer extends Transaction {

	private Long receiverId;

	public Transfer() {
	}

	public Transfer(Account account, Double amount, Instant timestamp, Long receiverId) {
		super(account, amount, timestamp);
		this.receiverId = receiverId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

}
