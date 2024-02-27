package com.carlos.banco.DTO.user;

import lombok.Getter;

@Getter
public class RegisterUserDTO{
    private final String name;
    private final String phone;
    private final String cpf;
    private final String password;

    public RegisterUserDTO(String name, String phone, String cpf, String password) {
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
        this.password = password;
    }

}