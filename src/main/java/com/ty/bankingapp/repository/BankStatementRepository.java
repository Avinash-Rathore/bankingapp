package com.ty.bankingapp.repository;

import com.ty.bankingapp.entity.BankStatement;
import com.ty.bankingapp.enums.StatementFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankStatementRepository extends JpaRepository<BankStatement, Integer> {

        List<BankStatement> findByAccount_AccountId(Integer accountId);

        List<BankStatement> findByFormat(StatementFormat format);
}
