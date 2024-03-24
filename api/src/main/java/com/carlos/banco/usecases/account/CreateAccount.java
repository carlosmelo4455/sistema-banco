package com.carlos.banco.usecases.account;

import com.carlos.banco.DTO.account.NewAccountDTO;
import com.carlos.banco.entities.Account;
import com.carlos.banco.entities.User;
import com.carlos.banco.enums.AccountType;
import com.carlos.banco.model.AccountModel;
import com.carlos.banco.model.UserModel;
import com.carlos.banco.repository.AccountRepository;
import com.carlos.banco.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class CreateAccount {
    private final AccountRepository accountRepository;
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public void execute(NewAccountDTO newAccountDTO) {
        UserModel existingUserModel = userRepository.findById(newAccountDTO.getUserId()).orElseThrow();
        if (accountRepository.existsByUserAndAccountType(existingUserModel, AccountType.stringToEnum(newAccountDTO.getAccountType()))) {
            throw new RuntimeException("Usuário já possui conta");
        }
        User existingUser = mapper.map(existingUserModel, User.class);
        Account newAccount = Account.createNewAccount(existingUser, AccountType.stringToEnum(newAccountDTO.getAccountType()));
        accountRepository.save(mapper.map(newAccount, AccountModel.class));
    }
}
