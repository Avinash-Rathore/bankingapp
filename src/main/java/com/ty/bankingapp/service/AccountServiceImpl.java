package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.Account;
import com.ty.bankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
      return  accountRepository.save(account);
    }

    @Override
    public Account findByAcno(String acno) {
        return accountRepository.findByAcno(acno);
    }

    @Override
    public List<Account> findByUserId(Integer userId) {
        return accountRepository.findByUser_UId(userId);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Boolean deleteAccount(Integer accountId) {
        accountRepository.deleteById(accountId);
        return true;
    }
}
