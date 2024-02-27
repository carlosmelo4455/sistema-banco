package com.carlos.banco.DTO.account;

import lombok.Getter;

@Getter
public class TransferBalanceDTO {
    private Long userId;
    private String accountOriginType;
    private String accountDestinationNumber;
    private String accountDestinationDigit;
    private String description;
    private double value;
}
