package com.carlos.banco.DTO.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserDTO{
    private String name;
    private String phone;
    private String cpf;
    private String password;
}