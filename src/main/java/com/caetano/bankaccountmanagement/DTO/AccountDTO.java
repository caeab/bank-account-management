package com.caetano.bankaccountmanagement.DTO;

import com.caetano.bankaccountmanagement.entities.Account;

public class AccountDTO {
	
	private Long identifier;
	private String name;
	private String description;
	private String status;
	
	public AccountDTO() {
	}
	
	public AccountDTO(Account entity) {
		this.identifier = entity.getIdentifier();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.status = entity.getStatus();
		
	}
	
	public AccountDTO(Long identifier, String name, String description, String status) {
		this.identifier = identifier;
		this.name = name;
		this.description = description;
		this.status = status;
	}
	public Long getIdentifier() {
		return identifier;
	}
	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
