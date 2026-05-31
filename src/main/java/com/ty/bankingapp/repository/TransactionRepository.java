package com.ty.bankingapp.repository;

import com.ty.bankingapp.entity.Account;
import com.ty.bankingapp.entity.Transaction;
import com.ty.bankingapp.enums.TransactionStatus;
import com.ty.bankingapp.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findBySenderAccount_AccountId(Integer accountId);

    List<Transaction> findByRecieverAccount_AccountId(Integer accountId);

    @Query("SELECT t FROM Transaction t WHERE" +
            "      t.senderAccount.accountId = :accountId" +
            "      OR t.recieverAccount.accountId = :accountId")
    List<Transaction> findAllByAccountId(@Param("accountId") Integer accountId);

    List<Transaction> findByTransactionStatus(TransactionStatus status);

    List<Transaction> findByTransactionType(TransactionType type);

}
