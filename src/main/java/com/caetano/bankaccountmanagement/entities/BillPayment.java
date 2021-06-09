package com.caetano.bankaccountmanagement.entities;

import java.time.Instant;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("billPayment")
public class BillPayment extends Transaction {

	private String barcode;
	private Instant expirationDate;

	public BillPayment() {
	}

	public BillPayment(Account account, Double amount, Instant timestamp, String barcode, Instant expirationDate) {
		super(account, amount, timestamp);
		this.barcode = barcode;
		this.expirationDate = expirationDate;
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
