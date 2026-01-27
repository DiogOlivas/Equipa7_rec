package com.upt.lp.Equipa7.service;

import org.springframework.stereotype.Service;
import com.upt.lp.Equipa7.repository.TransactionRepository;
import com.upt.lp.Equipa7.repository.UserRepository;

import java.util.*;

import com.upt.lp.Equipa7.DTO.TransactionDTO;
import com.upt.lp.Equipa7.entity.Transaction;
import com.upt.lp.Equipa7.entity.User;
import com.upt.lp.Equipa7.mapping.TransactionMapper;
//
@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }
    public List<com.upt.lp.Equipa7.entity.Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
    public Transaction createTransaction(TransactionDTO dto) {
        Transaction transaction = TransactionMapper.toEntity(dto, userRepository);
        return transactionRepository.save(transaction);
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