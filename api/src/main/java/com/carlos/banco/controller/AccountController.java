package com.carlos.banco.controller;

import com.carlos.banco.DTO.account.DepositBalanceDTO;
import com.carlos.banco.DTO.account.NewAccountDTO;
import com.carlos.banco.DTO.account.TransferBalanceDTO;
import com.carlos.banco.DTO.account.WithdrawalBalanceDTO;
import com.carlos.banco.usecases.account.CreateAccount;
import com.carlos.banco.usecases.account.DepositBalance;
import com.carlos.banco.usecases.account.TransferBalance;
import com.carlos.banco.usecases.account.WithdrawalBalance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final CreateAccount createAccount;
    private final DepositBalance depositBalance;
    private final TransferBalance transferBalance;
    private final WithdrawalBalance withdrawBalance;

    public AccountController(CreateAccount createAccount, DepositBalance depositBalance, TransferBalance transferBalance, WithdrawalBalance withdrawBalance) {
        this.createAccount = createAccount;
        this.depositBalance = depositBalance;
        this.transferBalance = transferBalance;
        this.withdrawBalance = withdrawBalance;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createAccount(@RequestBody NewAccountDTO newAccountDTO) {
        createAccount.execute(newAccountDTO);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/deposit")
    public ResponseEntity<Void> depositBalance(@RequestBody DepositBalanceDTO depositBalanceDTO) {
        depositBalance.execute(depositBalanceDTO);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/transfer")
    public ResponseEntity<Void> transferBalance(@RequestBody TransferBalanceDTO transferBalanceDTO) {
        transferBalance.execute(transferBalanceDTO);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/withdraw")
    public ResponseEntity<Void> withdrawBalance(@RequestBody WithdrawalBalanceDTO withdrawalBalanceDTO) {
        withdrawBalance.execute(withdrawalBalanceDTO);
        return ResponseEntity.ok().build();
    }
}
