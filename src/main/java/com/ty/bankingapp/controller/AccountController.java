package com.ty.bankingapp.controller;

import com.ty.bankingapp.entity.Account;
import com.ty.bankingapp.service.AccountService;
import com.ty.bankingapp.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
       Account savedAccount = accountService.createAccount(account);
        return new ResponseEntity<>(savedAccount,HttpStatus.CREATED);
    }

    @GetMapping("/acno/{acno}")
    public ResponseEntity<Account> findByAcNo(@PathVariable String acno){
        return new ResponseEntity<>(  accountService.findByAcno(acno),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> findByUserId(@PathVariable Integer userId){
        return new ResponseEntity<>(accountService.findByUserId(userId),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.updateAccount(account),HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable Integer accountId){
        return new ResponseEntity<>(accountService.deleteAccount(accountId),HttpStatus.OK);
    }

}
