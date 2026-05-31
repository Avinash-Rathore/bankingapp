package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.Transaction;
import com.ty.bankingapp.enums.TransactionStatus;
import com.ty.bankingapp.enums.TransactionType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    List<Transaction> getAllTransactions();

    List<Transaction> getTransactionsByAccountId(Integer accountId);

    Transaction getTransactionById(Integer tId);

    List<Transaction> getTransactionByStatus(TransactionStatus status);

    List<Transaction> getTransactionByType(TransactionType type);
}
