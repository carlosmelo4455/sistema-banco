package com.carlos.banco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "transactions")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String description;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private AccountModel sourceAccount;

    @ManyToOne
    @JoinColumn(name = "target_account_id")
    private AccountModel targetAccount;
}
