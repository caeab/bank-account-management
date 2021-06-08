package com.caetano.bankaccountmanagement.DTO;

import com.caetano.bankaccountmanagement.entities.Transfer;

public class TransferDTO {

	private Long senderId;
	private Long receiverId;
	private Double amount;
	
	public TransferDTO() {
	}
	
	public TransferDTO(Transfer obj) {
		this.senderId = obj.getAccount().getIdentifier();
		this.receiverId = obj.getReceiverId();
		this.amount = obj.getAmount();		
	}

	public TransferDTO(Long senderId, Long receiverId, Double amount) {
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.amount = amount;
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
	
	
}
