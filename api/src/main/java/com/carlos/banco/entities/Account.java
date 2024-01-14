package com.carlos.banco.entities;

import com.carlos.banco.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private User user;
    private String accountNumber;
    private String AccountDigit;
    private Double balance;
    private AccountType accountType;

    public void generateAccountNumber() {
        this.accountNumber = String.valueOf((int) (Math.random() * 1000000));
        this.AccountDigit = String.valueOf((int) (Math.random() * 10));
    }
}
