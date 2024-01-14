package com.carlos.banco.DTO;

import com.carlos.banco.entities.User;
import com.carlos.banco.model.UserModel;

public record UserDTO(String name, String phone, String cpf, String password) {
    public User toEntity() {
        return new User(this.name, this.phone, this.cpf, this.password);
    }
    public UserModel toModel() {
        return new UserModel(this.name, this.phone, this.cpf, this.password);
    }
}