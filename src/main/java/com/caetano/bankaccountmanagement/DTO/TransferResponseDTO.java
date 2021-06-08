package com.caetano.bankaccountmanagement.DTO;

import java.time.Instant;

import com.caetano.bankaccountmanagement.entities.Transfer;

public class TransferResponseDTO {

	private Long senderId;
	private Long receiverId;
	private Double amount;
	private Instant timestamp;
	
	public TransferResponseDTO() {
	}

	public TransferResponseDTO(Transfer obj) {
		this.senderId = obj.getAccount().getIdentifier();
		this.receiverId = obj.getReceiverId();
		this.amount = obj.getAmount();
		this.timestamp = obj.getTimestamp();
	}

	public TransferResponseDTO(Long senderId, Long receiverId, Double amount, Instant timestamp) {
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
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
