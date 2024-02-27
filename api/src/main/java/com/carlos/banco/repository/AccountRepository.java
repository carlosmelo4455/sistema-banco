package com.carlos.banco.repository;

import com.carlos.banco.enums.AccountType;
import com.carlos.banco.model.AccountModel;
import com.carlos.banco.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
    AccountModel findByAccountNumberAndAccountDigit(String accountNumber, String accountDigit);
    AccountModel findByUserAndAccountType(UserModel user, AccountType accountType);
    boolean existsByUserAndAccountType(UserModel user, AccountType accountType);
}
