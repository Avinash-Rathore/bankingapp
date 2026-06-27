package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.Admin;
import com.ty.bankingapp.enums.AdminRole;
import com.ty.bankingapp.enums.AdminStatus;

import java.util.List;

public interface AdminService {
     Admin createAdmin(Admin admin);
     Admin getAdminById(Integer adminId);
     List<Admin> getAll();
     Admin getAdminByEmail(String email);
     List<Admin> getAdminByRole(AdminRole role);
     List<Admin> getAdminByStatus(AdminStatus status);
     Admin updateAdmin(Admin admin);
     Boolean deleteAdmin(Integer adminId);
}
