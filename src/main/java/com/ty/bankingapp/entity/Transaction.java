package com.ty.bankingapp.entity;

import com.ty.bankingapp.enums.TransactionStatus;
import com.ty.bankingapp.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Builder
@Table(name = "transactions")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tId;

    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private Account senderAccount;
    @ManyToOne
    @JoinColumn(name = "reciever_account_id")
    private Account recieverAccount;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    private String description;

    @CreationTimestamp
    private LocalDateTime transactionDateAndTime;
}
