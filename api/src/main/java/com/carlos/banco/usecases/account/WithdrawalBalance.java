package com.carlos.banco.usecases.account;

import com.carlos.banco.DTO.account.DepositBalanceDTO;
import com.carlos.banco.DTO.account.WithdrawalBalanceDTO;
import com.carlos.banco.entities.Account;
import com.carlos.banco.enums.AccountType;
import com.carlos.banco.model.AccountModel;
import com.carlos.banco.model.UserModel;
import com.carlos.banco.repository.AccountRepository;
import com.carlos.banco.repository.UserRepository;
import config.MapperConfig;
import org.modelmapper.ModelMapper;

public class WithdrawalBalance {
    private final AccountRepository accountRepository;
    private final ModelMapper mapper = new MapperConfig().modelMapper();
    private final UserRepository userRepository;

    public WithdrawalBalance(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public void execute(WithdrawalBalanceDTO withdrawalBalanceDTO) {
        UserModel existingUserModel = userRepository.findById(withdrawalBalanceDTO.getUserId()).orElseThrow();
        AccountModel existingAccountModel = accountRepository.findByUserAndAccountType(existingUserModel, AccountType.stringToEnum(withdrawalBalanceDTO.getAccountType()));
        Account existingAccount = mapper.map(existingAccountModel, Account.class);
        existingAccount.withdrawal(withdrawalBalanceDTO.getValue());
        accountRepository.save(mapper.map(existingAccount, AccountModel.class));
    }
}
