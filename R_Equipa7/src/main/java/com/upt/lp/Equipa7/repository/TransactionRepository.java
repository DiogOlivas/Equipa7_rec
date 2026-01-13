package com.upt.lp.Equipa7.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upt.lp.Equipa7.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findById(Long id);
    
}
