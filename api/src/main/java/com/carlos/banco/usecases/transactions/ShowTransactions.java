package com.carlos.banco.usecases.transactions;

import com.carlos.banco.DTO.transaction.AllTransactionsDTO;
import com.carlos.banco.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ShowTransactions {

    private final TransactionRepository transactionRepository;
    private final ModelMapper mapper;

    public List<AllTransactionsDTO> execute() {
        return transactionRepository.findAll().stream()
                .map(transaction -> mapper.map(transaction, AllTransactionsDTO.class))
                .collect(Collectors.toList());
    }
}
