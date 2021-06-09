package com.caetano.bankaccountmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caetano.bankaccountmanagement.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}
