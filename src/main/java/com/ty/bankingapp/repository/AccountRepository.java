package com.ty.bankingapp.repository;

import com.ty.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account findByAcno(String acno);

    List<Account> findByUser_UId(Integer uId);

}
