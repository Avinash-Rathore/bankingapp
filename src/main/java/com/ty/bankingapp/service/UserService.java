package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.User;

public interface UserService {
    User registerUser(User user);
    User getUserById(int id);
    User getUserByEmail(String email);
    User getUserByMobile(String mobile);
}

