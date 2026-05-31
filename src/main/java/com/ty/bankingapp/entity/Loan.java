package com.ty.bankingapp.entity;

import com.ty.bankingapp.enums.LoanStatus;
import com.ty.bankingapp.enums.LoanType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loanId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

    private Double loanAmount;
    private Double interestRate;
    private Integer loanTenure;
    private Double monthlyInstallments;
    private Double remainingAmount;

    @Enumerated(EnumType.STRING)
    private LoanType loanType;
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    @CreationTimestamp
    private LocalDateTime appliedDate;

    private LocalDateTime approvedDate;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    private Admin approvedBy;

}
