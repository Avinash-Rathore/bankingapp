package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.Loan;
import com.ty.bankingapp.enums.LoanStatus;
import com.ty.bankingapp.enums.LoanType;

import java.util.List;

public interface LoanService {
    Loan applyLoan(Loan loan);
    Loan getLoanById(Integer loanId);
    List<Loan> getAllLoans();
    List<Loan> getLoanByUser(Integer uId);
    List<Loan> getLoanByAccount(Integer accountId);
    List<Loan> getLoanByStatus(LoanStatus status);
    List<Loan> getLoanByType(LoanType type);
    Loan updateLoan(Loan loan);
    Boolean deleteLoan(Integer loanId);
}
