package com.carlos.banco.usecases.user;

import com.carlos.banco.DTO.user.RegisterUserDTO;
import com.carlos.banco.entities.Account;
import com.carlos.banco.entities.User;
import com.carlos.banco.enums.AccountType;
import com.carlos.banco.model.AccountModel;
import com.carlos.banco.model.UserModel;
import com.carlos.banco.repository.AccountRepository;
import com.carlos.banco.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RegisterUser {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper mapper;

    private RegisterUser(UserRepository userRepository, AccountRepository accountRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.mapper = mapper;
    }

    public void execute(RegisterUserDTO userDTO) {
        if (userRepository.findByCpf(userDTO.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        } else {
            User user = mapper.map(userDTO, User.class);
            Account account = Account.createNewAccount(user, AccountType.Corrente);
            accountRepository.save(mapper.map(account, AccountModel.class));
            userRepository.save(mapper.map(user, UserModel.class));

        }
    }
}