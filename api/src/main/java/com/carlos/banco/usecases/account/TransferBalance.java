package com.carlos.banco.usecases.account;

import com.carlos.banco.DTO.account.TransferBalanceDTO;
import com.carlos.banco.entities.Account;
import com.carlos.banco.entities.Transaction;
import com.carlos.banco.enums.AccountType;
import com.carlos.banco.model.AccountModel;
import com.carlos.banco.model.TransactionModel;
import com.carlos.banco.model.UserModel;
import com.carlos.banco.repository.AccountRepository;
import com.carlos.banco.repository.TransactionRepository;
import com.carlos.banco.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransferBalance {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final ModelMapper mapper;

    public void execute(TransferBalanceDTO transferBalanceDTO) {
        UserModel existingUserModel = userRepository.findById(transferBalanceDTO.getUserId()).orElseThrow();
        AccountModel originAccountModel = accountRepository.findByUserAndAccountType(existingUserModel, AccountType.stringToEnum(transferBalanceDTO.getAccountOriginType()));
        Account originAccount = mapper.map(originAccountModel, Account.class);

        AccountModel destinationAccountModel = accountRepository.findByAccountNumberAndAccountDigit(transferBalanceDTO.getAccountDestinationNumber(), transferBalanceDTO.getAccountDestinationDigit());
        Account destinationAccount = mapper.map(destinationAccountModel, Account.class);

        if (originAccount.getBalance() < transferBalanceDTO.getValue()) {
            throw new IllegalArgumentException("Saldo insuficiente para transferencia");
        }

        originAccount.setBalance(originAccount.getBalance() - transferBalanceDTO.getValue());
        destinationAccount.setBalance(destinationAccount.getBalance() + transferBalanceDTO.getValue());

        Transaction transaction = new Transaction(transferBalanceDTO.getDescription(), transferBalanceDTO.getValue(), originAccount, destinationAccount);

        transactionRepository.save(mapper.map(transaction, TransactionModel.class));
        accountRepository.save(mapper.map(originAccount, AccountModel.class));
        accountRepository.save(mapper.map(destinationAccount, AccountModel.class));
    }
}