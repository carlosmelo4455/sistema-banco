package com.carlos.banco.controller;

import com.carlos.banco.DTO.transaction.AllTransactionsDTO;
import com.carlos.banco.usecases.transactions.ShowTransactions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    @Mock
    private ShowTransactions showTransactions;

    @InjectMocks
    private TransactionController transactionController;

    private List<AllTransactionsDTO> allTransactionsDTOList;

    @BeforeEach
    public void setup() {
        allTransactionsDTOList = Collections.singletonList(new AllTransactionsDTO());
    }

    @Test
    public void shouldShowTransactions() {
        when(showTransactions.execute()).thenReturn(allTransactionsDTOList);

        ResponseEntity<List<AllTransactionsDTO>> response = transactionController.showTransactions();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(allTransactionsDTOList, response.getBody());
    }
}