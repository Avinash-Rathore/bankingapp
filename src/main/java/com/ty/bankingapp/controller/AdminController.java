package com.ty.bankingapp.controller;

import com.ty.bankingapp.entity.Admin;
import com.ty.bankingapp.enums.AdminRole;
import com.ty.bankingapp.enums.AdminStatus;
import com.ty.bankingapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin a = adminService.createAdmin(admin);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
    @GetMapping("/get/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Integer adminId) {
        return new ResponseEntity<>(adminService.getAdminById(adminId),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Admin>> getAll() {
        return new ResponseEntity<>(adminService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/email")
    public ResponseEntity<Admin> getAdminByEmail(@PathVariable String email) {
        return new ResponseEntity<>(adminService.getAdminByEmail(email),HttpStatus.OK);
    }
    @GetMapping("/{role}")
    public  ResponseEntity<List<Admin>> getAdminByRole(@PathVariable AdminRole role) {
        return new ResponseEntity<>(adminService.getAdminByRole(role),HttpStatus.OK);
    }
    @GetMapping("/{status}")
    public  ResponseEntity<List<Admin>> getAdminByStatus(@PathVariable AdminStatus status) {
        return new ResponseEntity<>(adminService.getAdminByStatus(status),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<>(adminService.updateAdmin(admin),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{adminId}")
    public ResponseEntity<Boolean> deleteAdmin(@PathVariable Integer adminId) {
        return new ResponseEntity<>(adminService.deleteAdmin(adminId),HttpStatus.OK);
    }
}
