package com.caetano.bankaccountmanagement.DTO;

import com.caetano.bankaccountmanagement.entities.Credit;

public class CreditResponseDTO extends TransactionDTO{
	
	public CreditResponseDTO() {
	}
	
	public CreditResponseDTO(Credit obj) {
		super(obj);
	}

}
