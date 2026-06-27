package com.ty.bankingapp.repository;

import com.ty.bankingapp.entity.Admin;
import com.ty.bankingapp.enums.AdminRole;
import com.ty.bankingapp.enums.AdminStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findByAdminEmail(String email);
    List<Admin> findByRole(AdminRole role);
    List<Admin> findByStatus(AdminStatus status);
}
