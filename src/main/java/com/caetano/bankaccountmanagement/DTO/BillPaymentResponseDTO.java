package com.caetano.bankaccountmanagement.DTO;

import java.time.Instant;

import com.caetano.bankaccountmanagement.entities.BillPayment;

public class BillPaymentResponseDTO extends TransactionDTO {

	private String barcode;
	private Instant expirationDate;

	public BillPaymentResponseDTO() {
	}

	public BillPaymentResponseDTO(Long accountId, Double amount, Instant timestamp, String barcode,
			Instant expirationDate) {
		super(accountId, amount, timestamp);
		this.barcode = barcode;
		this.expirationDate = expirationDate;
	}

	public BillPaymentResponseDTO(BillPayment obj) {
		super(obj);
		this.barcode = obj.getBarcode();
		this.expirationDate = obj.getExpirationDate();
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Instant getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Instant expirationDate) {
		this.expirationDate = expirationDate;
	}

}
