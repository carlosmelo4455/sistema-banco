package com.carlos.banco.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountType {
    Poupanca("Poupanca", "Poupança"),
    Corrente("Corrente", "Corrente"),
    ;

    private final String nome;
    private final String descricao;

    public static AccountType stringToEnum(String accountType) {
        for (AccountType type : AccountType.values()) {
            if (type.name().equalsIgnoreCase(accountType)) {
                return type;
            }
        }
        return null;
    }
}
