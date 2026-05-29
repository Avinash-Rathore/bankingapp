package com.ty.bankingapp.repository;

import com.ty.bankingapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByMobile(String mobile);
    User findByEmail(String email);
}
