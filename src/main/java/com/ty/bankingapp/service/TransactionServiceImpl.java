package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.Account;
import com.ty.bankingapp.entity.Transaction;
import com.ty.bankingapp.enums.TransactionStatus;
import com.ty.bankingapp.enums.TransactionType;
import com.ty.bankingapp.repository.AccountRepository;
import com.ty.bankingapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {

        // Fetch full account objects from DB
        Account sender = null;
        Account receiver = null;

        if (transaction.getSenderAccount() != null) {
            sender = accountRepository.findById(
                    transaction.getSenderAccount().getAccountId()
            ).orElse(null);
        }

        if (transaction.getRecieverAccount() != null) {
            receiver = accountRepository.findById(
                    transaction.getRecieverAccount().getAccountId()
            ).orElse(null);
        }

        // Validate sufficient balance
        if (transaction.getTransactionType() == TransactionType.TRANSFER
                || transaction.getTransactionType() == TransactionType.WITHDRAWAL) {
            if (sender != null && sender.getBalance() < transaction.getAmount()) {
                throw new RuntimeException("Insufficient balance!");
            }
        }

        // Update balances
        if (transaction.getTransactionType() == TransactionType.TRANSFER) {
            sender.setBalance(sender.getBalance() - transaction.getAmount());
            receiver.setBalance(receiver.getBalance() + transaction.getAmount());
            accountRepository.save(sender);
            accountRepository.save(receiver);
            transaction.setSenderAccount(sender);
            transaction.setRecieverAccount(receiver);
        }

        if (transaction.getTransactionType() == TransactionType.DEPOSIT) {
            receiver.setBalance(receiver.getBalance() + transaction.getAmount());
            accountRepository.save(receiver);
            transaction.setRecieverAccount(receiver);
        }

        if (transaction.getTransactionType() == TransactionType.WITHDRAWAL) {
            sender.setBalance(sender.getBalance() - transaction.getAmount());
            accountRepository.save(sender);
            transaction.setSenderAccount(sender);
        }

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
