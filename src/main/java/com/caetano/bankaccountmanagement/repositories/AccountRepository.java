package com.caetano.bankaccountmanagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.caetano.bankaccountmanagement.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("SELECT obj FROM Account obj WHERE LOWER(obj.name) LIKE LOWER (CONCAT('%',:name,'%'))")
	Page<Account> searchName(String name, Pageable pageable);
}
