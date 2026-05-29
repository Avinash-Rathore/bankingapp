package com.ty.bankingapp.entity;

import com.ty.bankingapp.enums.AdminRole;
import com.ty.bankingapp.enums.AdminStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    private String adminName;
    private String adminEmail;
    private String adminPassword;

    @Enumerated(EnumType.STRING)
    private AdminRole role;
    @Enumerated(EnumType.STRING)
    private AdminStatus status;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
