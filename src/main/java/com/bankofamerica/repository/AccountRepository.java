package com.bankofamerica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankofamerica.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
