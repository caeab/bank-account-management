package com.caetano.bankaccountmanagement.conrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caetano.bankaccountmanagement.DTO.AccountDTO;
import com.caetano.bankaccountmanagement.entities.Account;
import com.caetano.bankaccountmanagement.services.AccountService;

@RestController
@RequestMapping(value="accounts")
public class AccountController {
	
	@Autowired
	//private AccountRepository accountRepository;
	private AccountService accountService;
	
	public AccountController() {
	}
	
	@GetMapping
    public ResponseEntity<List<Account>> findAll() {
        List<Account> list = accountService.findAll();
        return ResponseEntity.ok().body(list);
    }
	
	@GetMapping(value="/{id}") 
	public ResponseEntity<Account> findById(@PathVariable Long id){
		Account account = accountService.findById(id);
		
		return ResponseEntity.ok().body(account);		
	}
	
	@PostMapping(value="/insert")
	public ResponseEntity<Account> insert(@RequestBody AccountDTO entity){
		Account account = accountService.insert(entity);		
		return ResponseEntity.ok().body(account);		
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<Account> update(@PathVariable("id") long id, @RequestBody Account entity) {
		Account account = accountService.update(id, entity);		
		return ResponseEntity.ok().body(account);		
	}
	
	@GetMapping(value="/balance/{id}") 
	public ResponseEntity<Double> getBalanceById(@PathVariable Long id){
		Double balance = accountService.getBalance(id);		
		return ResponseEntity.ok().body(balance);		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") Long id){
		accountService.delete(id);
		return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

	@PutMapping("/credit/{id}")
	public ResponseEntity<Account> credit(@PathVariable("id") long id, @RequestBody Account entity) {
		Account account = accountService.credit(id, entity);		
		return ResponseEntity.ok().body(account);		
	}
	

}
