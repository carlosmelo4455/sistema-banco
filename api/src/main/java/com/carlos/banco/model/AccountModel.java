package com.carlos.banco.model;

import com.carlos.banco.entities.Transaction;
import com.carlos.banco.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "accounts")
public class AccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    private String accountNumber;
    private String accountDigit;
    private double balance;
    private AccountType accountType;
    @OneToMany(mappedBy = "transactions")
    private List<TransactionModel> Transactions;

}
