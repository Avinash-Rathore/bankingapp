package com.ty.bankingapp.entity;

import com.ty.bankingapp.enums.StatementFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bank_statement")
public class BankStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statementId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Double openingBal;

    private Double closingBal;

    @Enumerated(EnumType.STRING)
    private StatementFormat format;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
