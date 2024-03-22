package com.carlos.banco.config;

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
//        mapper.createTypeMap(TransactionModel.class, AllTransactionsDTO.class)
//                .addMappings(m -> m.map(src -> src.getDate().toString(), AllTransactionsDTO::setDate))
//                .addMappings(m -> m.map(src -> src.getSourceAccount().getAccountNumber().concat("-")
//                        .concat(src.getSourceAccount().getAccountDigit()), AllTransactionsDTO::setSourceAccount))
//                .addMappings(m -> m.map(src -> src.getTargetAccount().getAccountNumber().concat("-")
//                        .concat(src.getTargetAccount().getAccountDigit()), AllTransactionsDTO::setTargetAccount));
        return mapper;
    }
}