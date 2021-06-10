package com.caetano.bankaccountmanagement.DTO;

import java.time.Instant;

import com.caetano.bankaccountmanagement.entities.Transfer;

public class TransferResponseDTO extends TransactionDTO {

	private Long receiverId;

	public TransferResponseDTO() {
	}

	public TransferResponseDTO(Transfer obj) {
		super(obj);
		this.receiverId = obj.getReceiverId();
	}

	public TransferResponseDTO(Long senderId, Long receiverId, Double amount, Instant timestamp) {
		super(senderId, amount, timestamp);
		this.receiverId = receiverId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
}
