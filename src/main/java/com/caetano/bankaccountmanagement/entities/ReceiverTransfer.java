package com.caetano.bankaccountmanagement.entities;

import java.time.Instant;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("receiverTransfer")
public class ReceiverTransfer extends Transaction {

	private Long senderId;

	public ReceiverTransfer() {
	}

	public ReceiverTransfer(Account account, Double amount, Instant timestamp, Long senderID) {
		super(account, amount, timestamp);
		this.senderId = senderID;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

}
