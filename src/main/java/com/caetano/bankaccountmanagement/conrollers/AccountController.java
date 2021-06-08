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

import com.caetano.bankaccountmanagement.DTO.AccountBalanceDTO;
import com.caetano.bankaccountmanagement.DTO.AccountDTO;
import com.caetano.bankaccountmanagement.DTO.CreditDTO;
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
	public ResponseEntity<List<AccountDTO>> findAll() {
		List<AccountDTO> list = accountService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value="Retorna uma conta única")
	@GetMapping(value = "/{id}")
	public ResponseEntity<AccountDTO> findById(@PathVariable Long id) {
		AccountDTO accountDTO = new AccountDTO(accountService.findById(id));
		return ResponseEntity.ok().body(accountDTO);
	}

	@ApiOperation(value="Insere uma nova conta")
	@PostMapping(value = "/insert")
	public ResponseEntity<AccountDTO> insert(@RequestBody AccountDTO entity) {
		AccountDTO accountDTO = accountService.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(accountDTO.getIdentifier()).toUri();
		return ResponseEntity.created(uri).body(accountDTO);
	}

	@ApiOperation(value="Atualiza uma conta existente")
	@PutMapping("/update/{id}")
	public ResponseEntity<AccountDTO> update(@PathVariable("id") long id, @RequestBody AccountDTO entity) {
		AccountDTO accountDTO = accountService.update(id, entity);
		return ResponseEntity.ok().body(accountDTO);
	}

	@ApiOperation(value="Retorna o saldo de uma conta")
	@GetMapping(value = "/balance/{id}")
	public ResponseEntity<AccountBalanceDTO> getBalanceById(@PathVariable Long id) {
		AccountBalanceDTO accountBalanceDTO = accountService.getBalance(id);
		return ResponseEntity.ok().body(accountBalanceDTO);
	}

	@ApiOperation(value="Deleta uma conta")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") Long id) {
		accountService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value="Entrada de créditos para uma conta")
	@PostMapping("/credit")
	public ResponseEntity<AccountBalanceDTO> credit(@RequestBody CreditDTO entity) {
		AccountBalanceDTO accountBalanceDTO = accountService.credit(entity);
		return ResponseEntity.ok().body(accountBalanceDTO);
	}

}
