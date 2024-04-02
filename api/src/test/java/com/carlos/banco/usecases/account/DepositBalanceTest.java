package com.carlos.banco.usecases.account;

import com.carlos.banco.DTO.account.DepositBalanceDTO;
import com.carlos.banco.entities.Account;
import com.carlos.banco.enums.AccountType;
import com.carlos.banco.model.AccountModel;
import com.carlos.banco.model.UserModel;
import com.carlos.banco.repository.AccountRepository;
import com.carlos.banco.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepositBalanceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private DepositBalance depositBalance;

    private DepositBalanceDTO depositBalanceDTO;
    private UserModel userModel;
    private AccountModel accountModel;

    @BeforeEach
    public void setup() {
        depositBalanceDTO = new DepositBalanceDTO();
        depositBalanceDTO.setUserId(1L);
        depositBalanceDTO.setAccountType("Corrente");
        depositBalanceDTO.setValue(100.0);

        userModel = new UserModel();
        userModel.setId(1L);

        accountModel = new AccountModel();
        accountModel.setUser(userModel);
        accountModel.setAccountType(AccountType.Corrente);
    }

    @Test
    public void shouldDepositBalanceWhenUserAndAccountExist() {
        when(userRepository.findById(depositBalanceDTO.getUserId())).thenReturn(Optional.of(userModel));
        when(accountRepository.findByUserAndAccountType(userModel, AccountType.stringToEnum(depositBalanceDTO.getAccountType()))).thenReturn(accountModel);
        when(modelMapper.map(accountModel, Account.class)).thenReturn(new Account());
        when(modelMapper.map(any(Account.class), eq(AccountModel.class))).thenReturn(accountModel);

        depositBalance.execute(depositBalanceDTO);

        verify(accountRepository, times(1)).save(accountModel);
    }

    @Test
    public void shouldThrowExceptionWhenUserDoesNotExist() {
        when(userRepository.findById(depositBalanceDTO.getUserId())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> depositBalance.execute(depositBalanceDTO));
    }

    @Test
    public void shouldThrowExceptionWhenAccountDoesNotExist() {
        when(userRepository.findById(depositBalanceDTO.getUserId())).thenReturn(Optional.of(userModel));
        when(accountRepository.findByUserAndAccountType(userModel, AccountType.stringToEnum(depositBalanceDTO.getAccountType()))).thenReturn(null);

        assertThrows(RuntimeException.class, () -> depositBalance.execute(depositBalanceDTO));
    }
}