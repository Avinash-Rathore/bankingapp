package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.BankStatement;
import com.ty.bankingapp.enums.StatementFormat;

import java.util.List;

public interface BankStatementService {
   BankStatement createStatement(BankStatement statement);

   BankStatement getStatementById(Integer statementId);

   List<BankStatement> getAllBankStatements();

   List<BankStatement> getStatementsByAccountId(Integer accountId);

   List<BankStatement> getStatementsByFormat(StatementFormat format);

   Boolean deleteStatement(Integer statementId);
}
