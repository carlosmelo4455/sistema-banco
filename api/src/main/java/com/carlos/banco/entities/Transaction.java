package com.carlos.banco.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Date date;
    private String description;
    private Double amount;
    private Account sourceAccount;
    private Account targetAccount;

public Transaction(String description, Double amount, Account sourceAccount, Account targetAccount) {
        this.description = description;
        this.amount = amount;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
    }
}