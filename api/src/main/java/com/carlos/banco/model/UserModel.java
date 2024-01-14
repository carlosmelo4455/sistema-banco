package com.carlos.banco.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String cpf;
    private String password;

    public UserModel(String name, String phone, String cpf, String password) {
        this.name = name;
        this.phone = phone;
        this.cpf = cpf;
        this.password = password;
    }
}