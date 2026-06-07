package com.ty.bankingapp.controller;

import com.ty.bankingapp.entity.BankStatement;
import com.ty.bankingapp.enums.StatementFormat;
import com.ty.bankingapp.service.BankStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statement")
public class BankStatementController {

    @Autowired
    private BankStatementService bankStatementService;

    @PostMapping("/create")
    public ResponseEntity<BankStatement> createStatement(@RequestBody BankStatement statement){
        return new ResponseEntity<>(bankStatementService.createStatement(statement),HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BankStatement>> getAllStatements(){
        return new ResponseEntity<>(bankStatementService.getAllBankStatements(),HttpStatus.OK);
    }

    @GetMapping("/getByAccount/{accountId}")
    public ResponseEntity<List<BankStatement>> getStatementsByAccountId(@PathVariable Integer accountId){
        return new ResponseEntity<>(bankStatementService.getStatementsByAccountId(accountId),HttpStatus.OK);
    }

    @GetMapping("/getByFormat/{format}")
    public ResponseEntity<List<BankStatement>> getStatementsByFormat(@PathVariable StatementFormat format){
        return new ResponseEntity<>(bankStatementService.getStatementsByFormat(format),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{statementId}")
    public ResponseEntity<Boolean> deleteStatement(@PathVariable Integer statementId){
        return new ResponseEntity<>(bankStatementService.deleteStatement(statementId),HttpStatus.OK);
    }
}
