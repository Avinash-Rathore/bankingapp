package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.BankStatement;
import com.ty.bankingapp.enums.StatementFormat;
import com.ty.bankingapp.repository.BankStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankStatementServiceImpl implements BankStatementService {

    @Autowired
    private BankStatementRepository bankStatementRepository;

    @Override
    public BankStatement createStatement(BankStatement statement) {
        return bankStatementRepository.save(statement);
    }

    @Override
    public BankStatement getStatementById(Integer statementId) {
        return bankStatementRepository.findById(statementId).orElse(null);
    }

    @Override
    public List<BankStatement> getAllBankStatements() {
        return bankStatementRepository.findAll();
    }

    @Override
    public List<BankStatement> getStatementsByAccountId(Integer accountId) {
        return bankStatementRepository.findByAccount_AccountId(accountId);
    }

    @Override
    public List<BankStatement> getStatementsByFormat(StatementFormat format) {
        return bankStatementRepository.findByFormat(format);
    }

    @Override
    public Boolean deleteStatement(Integer statementId) {
        bankStatementRepository.deleteById(statementId);
        return true;
    }
}
