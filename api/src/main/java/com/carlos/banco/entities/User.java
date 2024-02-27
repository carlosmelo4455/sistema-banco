package com.carlos.banco.entities;

import com.carlos.banco.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String phone;
    private String cpf;
    private String password;

    public User(String name, String phone, String cpf, String password) {
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
        this.password = password;
    }
}