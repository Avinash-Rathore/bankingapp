package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.Transaction;
import com.ty.bankingapp.enums.TransactionStatus;
import com.ty.bankingapp.enums.TransactionType;
import com.ty.bankingapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {

        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(Integer accountId) {
        return transactionRepository.findAllByAccountId(accountId);
    }

    @Override
    public Transaction getTransactionById(Integer tId) {
        return transactionRepository.findById(tId).orElse(null);
    }

    @Override
    public List<Transaction> getTransactionByStatus(TransactionStatus status) {
        return transactionRepository.findByTransactionStatus(status);
    }

    @Override
    public List<Transaction> getTransactionByType(TransactionType type) {
        return transactionRepository.findByTransactionType(type);
    }
}
