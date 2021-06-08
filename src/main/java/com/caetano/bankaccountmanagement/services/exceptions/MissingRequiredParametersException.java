package com.caetano.bankaccountmanagement.services.exceptions;

public class MissingRequiredParametersException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public MissingRequiredParametersException(String msg) {
		super(msg);		
	}

}
