package com.carlos.banco.DTO.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepositBalanceDTO {
    private Long userId;
    private String accountType;
    private double value;
}
