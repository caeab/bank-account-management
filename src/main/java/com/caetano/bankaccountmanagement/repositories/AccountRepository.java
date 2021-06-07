package com.caetano.bankaccountmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caetano.bankaccountmanagement.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
