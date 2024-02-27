package com.carlos.banco.DTO.account;

import lombok.Getter;

@Getter
public class WithdrawalBalanceDTO {
    private Long userId;
    private String accountType;
    private double value;
}
