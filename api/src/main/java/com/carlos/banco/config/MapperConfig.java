package com.carlos.banco.config;

import com.carlos.banco.DTO.transaction.AllTransactionsDTO;
import com.carlos.banco.model.TransactionModel;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        mapper.getConfiguration().setSkipNullEnabled(true);
        mapper.createTypeMap(TransactionModel.class, AllTransactionsDTO.class)
                .addMappings(m -> m.map(src -> src.getDate() != null ? src.getDate().toString() : null, AllTransactionsDTO::setDate))
                .addMappings(m -> m.map(src -> src.getSourceAccount() != null && src.getSourceAccount().getAccountNumber() != null
                        && src.getSourceAccount().getAccountDigit() != null ? src.getSourceAccount().getAccountNumber().concat("-").concat(src.getSourceAccount().getAccountDigit())
                        : null, AllTransactionsDTO::setSourceAccount))
                .addMappings(m -> m.map(src -> src.getTargetAccount() != null && src.getTargetAccount().getAccountNumber() != null
                        && src.getTargetAccount().getAccountDigit() != null ? src.getTargetAccount().getAccountNumber().concat("-").concat(src.getTargetAccount().getAccountDigit())
                        : null, AllTransactionsDTO::setTargetAccount));
        return mapper;
    }
}