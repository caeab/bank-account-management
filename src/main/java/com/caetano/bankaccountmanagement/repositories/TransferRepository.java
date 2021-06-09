package com.caetano.bankaccountmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.caetano.bankaccountmanagement.entities.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

	@Query("from Transfer")
	public List<Transfer> getTransfers();
}
