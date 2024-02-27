package com.carlos.banco.DTO.account;

import com.carlos.banco.enums.AccountType;
import lombok.Getter;

@Getter
public class NewAccountDTO {
    private Long userId;
    private String accountType;

}
