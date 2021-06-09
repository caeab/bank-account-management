package com.caetano.bankaccountmanagement.entities;

import java.time.Instant;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("credit")
public class Credit extends Transaction {

	public Credit(Account account, Double amount, Instant timestamp) {
		super(account, amount, timestamp);
	}
}
