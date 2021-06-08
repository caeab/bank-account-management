package com.caetano.bankaccountmanagement.conrollers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caetano.bankaccountmanagement.DTO.AccountDTO;
import com.caetano.bankaccountmanagement.DTO.TransferDTO;
import com.caetano.bankaccountmanagement.entities.Account;
import com.caetano.bankaccountmanagement.services.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="Bank Account CRUD API REST")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	public AccountController() {
	}

	@ApiOperation(value="Retorna uma lista com todas as contas")
	@GetMapping
	public ResponseEntity<List<Account>> findAll() {
		List<Account> list = accountService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value="Retorna uma conta única")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Account> findById(@PathVariable Long id) {
		Account account = accountService.findById(id);
		return ResponseEntity.ok().body(account);
	}

	@ApiOperation(value="Insere uma nova conta")
	@PostMapping(value = "/insert")
	public ResponseEntity<Account> insert(@RequestBody AccountDTO entity) {
		Account account = accountService.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(account.getIdentifier()).toUri();
		return ResponseEntity.created(uri).body(account);
	}

	@ApiOperation(value="Atualiza uma conta existente")
	@PutMapping("/update/{id}")
	public ResponseEntity<Account> update(@PathVariable("id") long id, @RequestBody Account entity) {
		Account account = accountService.update(id, entity);
		return ResponseEntity.ok().body(account);
	}

	@ApiOperation(value="Retorna o saldo de uma conta")
	@GetMapping(value = "/balance/{id}")
	public ResponseEntity<Double> getBalanceById(@PathVariable Long id) {
		Double balance = accountService.getBalance(id);
		return ResponseEntity.ok().body(balance);
	}

	@ApiOperation(value="Deleta uma conta")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") Long id) {
		accountService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value="Entrada de créditos para uma conta")
	@PostMapping("/credit/{id}")
	public ResponseEntity<Account> credit(@PathVariable("id") long id, @RequestBody TransferDTO entity) {
		Account account = accountService.credit(id, entity);
		return ResponseEntity.ok().body(account);
	}

}
