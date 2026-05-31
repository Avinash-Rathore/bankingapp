package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.Loan;
import com.ty.bankingapp.enums.LoanStatus;
import com.ty.bankingapp.enums.LoanType;
import com.ty.bankingapp.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{

   @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan applyLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(Integer loanId) {
        return loanRepository.findById(loanId).orElse(null);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> getLoanByUser(Integer uId) {
        return loanRepository.findByUser_UId(uId);
    }

    @Override
    public List<Loan> getLoanByAccount(Integer accountId) {
        return loanRepository.findByAccount_AccountId(accountId);
    }

    @Override
    public List<Loan> getLoanByStatus(LoanStatus status) {
        return loanRepository.findByLoanStatus(status);
    }

    @Override
    public List<Loan> getLoanByType(LoanType type) {
        return loanRepository.findByLoanType(type);
    }

    @Override
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Boolean deleteLoan(Integer loanId) {
         loanRepository.deleteById(loanId);
         return true;
    }
}
