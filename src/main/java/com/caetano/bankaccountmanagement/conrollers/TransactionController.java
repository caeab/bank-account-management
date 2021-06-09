package com.caetano.bankaccountmanagement.conrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caetano.bankaccountmanagement.DTO.AccountBalanceDTO;
import com.caetano.bankaccountmanagement.DTO.BillPaymentDTO;
import com.caetano.bankaccountmanagement.DTO.TransferRequestDTO;
import com.caetano.bankaccountmanagement.DTO.TransferResponseDTO;
import com.caetano.bankaccountmanagement.entities.Transaction;
import com.caetano.bankaccountmanagement.services.TransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Bank Account CRUD API REST")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "transactions")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@ApiOperation(value = "Realiza uma transferência entre contas internas")
	@PostMapping(value = "/transfer")
	public ResponseEntity<TransferResponseDTO> makeTransfer(@RequestBody TransferRequestDTO entity) {
		TransferResponseDTO transferResponseDTO = transactionService.makeTransfer(entity);
		return ResponseEntity.ok().body(transferResponseDTO);
	}

	@ApiOperation(value = "Retorna uma lista com todas as transferencias")
	@GetMapping(value = "/transfer")
	public ResponseEntity<List<TransferResponseDTO>> findAllTransfer() {
		List<TransferResponseDTO> list = transactionService.findAllTransfer();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Retorna uma lista com todas as transações")
	@GetMapping
	public ResponseEntity<List<Transaction>> findAll() {
		List<Transaction> list = transactionService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Realiza o pagamento de um boleto")
	@PostMapping(value = "/payment/bill")
	public ResponseEntity<AccountBalanceDTO> payBill(@RequestBody BillPaymentDTO entity) {
		AccountBalanceDTO accountBalanceDTO = transactionService.payBill(entity);
		return ResponseEntity.ok().body(accountBalanceDTO);
	}

}
