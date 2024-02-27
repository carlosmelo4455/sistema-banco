package com.carlos.banco.DTO.transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllTransactionsDTO {
    private Long id;
    private String date;
    private String description;
    private Double amount;
    private String sourceAccount;
    private String targetAccount;
}
