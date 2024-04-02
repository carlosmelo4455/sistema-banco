package com.carlos.banco.controller;

import com.carlos.banco.DTO.account.DepositBalanceDTO;
import com.carlos.banco.DTO.account.NewAccountDTO;
import com.carlos.banco.DTO.account.TransferBalanceDTO;
import com.carlos.banco.DTO.account.WithdrawalBalanceDTO;
import com.carlos.banco.usecases.account.CreateAccount;
import com.carlos.banco.usecases.account.DepositBalance;
import com.carlos.banco.usecases.account.TransferBalance;
import com.carlos.banco.usecases.account.WithdrawalBalance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @Mock
    private DepositBalance depositBalance;

    @Mock
    private CreateAccount createAccount;

    @Mock
    private TransferBalance transferBalance;

    @Mock
    private WithdrawalBalance withdrawBalance;

    @InjectMocks
    private AccountController accountController;

    private NewAccountDTO newAccountDTO;
    private DepositBalanceDTO depositBalanceDTO;
    private TransferBalanceDTO transferBalanceDTO;
    private WithdrawalBalanceDTO withdrawalBalanceDTO;

    @BeforeEach
    public void setup() {
        newAccountDTO = new NewAccountDTO();
        depositBalanceDTO = new DepositBalanceDTO();
        transferBalanceDTO = new TransferBalanceDTO();
        withdrawalBalanceDTO = new WithdrawalBalanceDTO();
    }

    @Test
    public void shouldCreateAccount() {
        accountController.createAccount(newAccountDTO);
        verify(createAccount, times(1)).execute(newAccountDTO);
    }

    @Test
    public void shouldDepositBalance() {
        accountController.depositBalance(depositBalanceDTO);
        verify(depositBalance, times(1)).execute(depositBalanceDTO);
    }

    @Test
    public void shouldTransferBalance() {
        accountController.transferBalance(transferBalanceDTO);
        verify(transferBalance, times(1)).execute(transferBalanceDTO);
    }

    @Test
    public void shouldWithdrawBalance() {
        accountController.withdrawBalance(withdrawalBalanceDTO);
        verify(withdrawBalance, times(1)).execute(withdrawalBalanceDTO);
    }
}