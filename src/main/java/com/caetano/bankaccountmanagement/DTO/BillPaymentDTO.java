package com.caetano.bankaccountmanagement.DTO;

import java.time.Instant;

import com.caetano.bankaccountmanagement.entities.BillPayment;

public class BillPaymentDTO {

	private Long payerID;
	private String barcode;
	private Instant expirationDate;
	private Double amount;

	public BillPaymentDTO() {
	}

	public BillPaymentDTO(BillPayment obj) {
		this.payerID = obj.getAccount().getIdentifier();
		this.barcode = obj.getBarcode();
		this.expirationDate = obj.getExpirationDate();
		this.amount = obj.getAmount();
	}

	public BillPaymentDTO(Long payerID, String barcode, Instant expirationDate, Double amount) {
		super();
		this.payerID = payerID;
		this.barcode = barcode;
		this.expirationDate = expirationDate;
		this.amount = amount;
	}

	public Long getPayerID() {
		return payerID;
	}

	public void setPayerID(Long payerID) {
		this.payerID = payerID;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
