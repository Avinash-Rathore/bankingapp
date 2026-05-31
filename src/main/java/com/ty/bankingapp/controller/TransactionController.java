package com.ty.bankingapp.controller;

import com.ty.bankingapp.entity.Transaction;
import com.ty.bankingapp.enums.TransactionStatus;
import com.ty.bankingapp.enums.TransactionType;
import com.ty.bankingapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction){
       return new ResponseEntity<>(transactionService.saveTransaction(transaction),HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(),HttpStatus.OK);
    }
    @GetMapping("/{tId}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer tId){
        return new ResponseEntity<>(transactionService.getTransactionById(tId),HttpStatus.OK);
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Transaction>> getTransactionByStatus(@PathVariable TransactionStatus status){
        return new ResponseEntity<>(transactionService.getTransactionByStatus(status),HttpStatus.OK);
    }
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Transaction>> getTransactionByType(@PathVariable TransactionType type){
        return new ResponseEntity<>(transactionService.getTransactionByType(type),HttpStatus.OK);
    }
    @GetMapping("/accountId/{accountId}")
    public ResponseEntity<List<Transaction>> getAllByAccountId(@PathVariable Integer accountId){
        return new ResponseEntity<>(transactionService.getTransactionsByAccountId(accountId),HttpStatus.OK);
    }
}
