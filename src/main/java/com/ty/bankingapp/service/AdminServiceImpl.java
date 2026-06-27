package com.ty.bankingapp.service;

import com.ty.bankingapp.entity.Admin;
import com.ty.bankingapp.enums.AdminRole;
import com.ty.bankingapp.enums.AdminStatus;
import com.ty.bankingapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Integer adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminRepository.findByAdminEmail(email);
    }

    @Override
    public List<Admin> getAdminByRole(AdminRole role) {
        return adminRepository.findByRole(role);
    }

    @Override
    public List<Admin> getAdminByStatus(AdminStatus status) {
        return adminRepository.findByStatus(status);
    }
    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Boolean deleteAdmin(Integer adminId) {
        adminRepository.deleteById(adminId);
        return true;
    }
}
