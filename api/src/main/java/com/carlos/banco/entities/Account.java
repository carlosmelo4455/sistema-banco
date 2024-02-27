package com.carlos.banco.entities;

import com.carlos.banco.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private User accountHolder;
    private String accountNumber;
    private String AccountDigit;
    private Double balance;
    private AccountType accountType;
    private List<Transaction> Transactions;

    private Account(User accountHolder) {
        this.accountHolder = accountHolder;
    }

    public static Account createNewAccount(User user, AccountType accountType) {
        Account account = new Account(user);
        account.generateAccountNumber();
        account.setBalance(0.0);
        account.setAccountType(accountType);
        return account;
    }

    private void generateAccountNumber() {
        this.accountNumber = String.valueOf((int) (Math.random() * 1000000));
        this.AccountDigit = String.valueOf((int) (Math.random() * 10));
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdrawal(double value) {
        if (this.balance < value) {
            throw new IllegalArgumentException("Saldo insuficiente para saque");
        }
        this.balance -= value;
    }
}
