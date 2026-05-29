package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.Account;
import java.util.List;

public interface AccountService {
    //creating an account
    Account createAccount(Account account);

    //Finding the account using acno
    Account findByAcno(String acno);

    //Finding the account using userId
    List<Account> findByUserId(Integer userId);

    //Displaying all the accounts
    List<Account> getAllAccounts();

    //Updating any existing account
    Account updateAccount(Account account);

    //Delete an account
    Boolean deleteAccount(Integer accountId);
}
