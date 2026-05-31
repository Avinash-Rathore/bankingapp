package com.ty.bankingapp.repository;

import com.ty.bankingapp.entity.Loan;
import com.ty.bankingapp.enums.LoanStatus;
import com.ty.bankingapp.enums.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
   List<Loan> findByAccount_AccountId(Integer accountId);
   List<Loan> findByUser_UId(Integer uId);
   List<Loan> findByLoanStatus(LoanStatus status);
   List<Loan> findByLoanType(LoanType status);

}
