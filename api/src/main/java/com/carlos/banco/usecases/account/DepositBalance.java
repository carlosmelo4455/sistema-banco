package com.carlos.banco.usecases.account;
import com.carlos.banco.DTO.account.DepositBalanceDTO;
import com.carlos.banco.entities.Account;
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
public class DepositBalance {

    private final AccountRepository accountRepository;
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public void execute(DepositBalanceDTO depositBalanceDTO) {
        UserModel existingUserModel = userRepository.findById(depositBalanceDTO.getUserId()).orElseThrow();
        AccountModel existingAccountModel = accountRepository.findByUserAndAccountType(existingUserModel, AccountType.stringToEnum(depositBalanceDTO.getAccountType()));
        Account existingAccount = mapper.map(existingAccountModel, Account.class);
        existingAccount.deposit(depositBalanceDTO.getValue());
        accountRepository.save(mapper.map(existingAccount, AccountModel.class));
    }
}