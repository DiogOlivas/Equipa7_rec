package com.upt.lp.Equipa7.service;

import org.springframework.stereotype.Service;

import com.upt.lp.Equipa7.repository.TransactionRepository;
import java.util.*;
import com.upt.lp.Equipa7.entity.Transaction;
//
@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public List<com.upt.lp.Equipa7.entity.Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
    public Transaction createTransaction(Transaction t) {
        return transactionRepository.save(t);
    }
    public Transaction saveTransaction(Transaction t) {
        return transactionRepository.save(t);
    }
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction existing = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        existing.setValue(updatedTransaction.getValue());
        existing.setDescription(updatedTransaction.getDescription());
        existing.setDate(updatedTransaction.getDate());
        return transactionRepository.save(existing);
    }
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}