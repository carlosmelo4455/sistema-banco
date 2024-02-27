package com.carlos.banco.controller;

import com.carlos.banco.DTO.transaction.AllTransactionsDTO;
import com.carlos.banco.usecases.transactions.ShowTransactions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final ShowTransactions showTransactions;

    public TransactionController(ShowTransactions showTransactions) {
        this.showTransactions = showTransactions;
    }

    @GetMapping("/show")
    public ResponseEntity<List<AllTransactionsDTO>> showTransactions(){
        List<AllTransactionsDTO> transactions = showTransactions.execute();
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }
}
