package com.ty.bankingapp.controller;

import com.ty.bankingapp.entity.Loan;
import com.ty.bankingapp.enums.LoanStatus;
import com.ty.bankingapp.enums.LoanType;
import com.ty.bankingapp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<Loan> applyLoan(@RequestBody Loan loan){
        return new ResponseEntity<>(loanService.applyLoan(loan), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Loan> updateLoan(@RequestBody Loan loan){
        return new ResponseEntity<>(loanService.updateLoan(loan), HttpStatus.OK);
    }

    @DeleteMapping("/{lId}")
    public ResponseEntity<Boolean> deleteLoan(@PathVariable Integer loanId){
     return new ResponseEntity<>(loanService.deleteLoan(loanId),HttpStatus.OK);
    }

    @GetMapping("/{lId}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Integer loanId){
        return new ResponseEntity<>(loanService.getLoanById(loanId),HttpStatus.OK);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Loan>> getLoanByAccountId(@PathVariable Integer accountId){
        return new ResponseEntity<>(loanService.getLoanByAccount(accountId),HttpStatus.OK);
    }

    @GetMapping("/user/{uId}")
    public ResponseEntity<List<Loan>> getLoanByUserId(@PathVariable Integer uId){
        return new ResponseEntity<>(loanService.getLoanByUser(uId),HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Loan>> getLoanByStatus(@PathVariable LoanStatus status){
        return new ResponseEntity<>(loanService.getLoanByStatus(status),HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Loan>> getLoanByType(@PathVariable LoanType type){
        return new ResponseEntity<>(loanService.getLoanByType(type),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Loan>> getAllLoans(){
        return new ResponseEntity<>(loanService.getAllLoans(),HttpStatus.OK);
    }

}
