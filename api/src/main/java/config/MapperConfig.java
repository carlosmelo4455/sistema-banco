package config;

import com.carlos.banco.DTO.transaction.AllTransactionsDTO;
import com.carlos.banco.model.TransactionModel;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    ModelMapper mapper = new ModelMapper();

    @Bean
    public ModelMapper modelMapper() {
        mapper.getConfiguration().setAmbiguityIgnored(true);
        mapper.getConfiguration().setSkipNullEnabled(true);
        mapper.createTypeMap(TransactionModel.class, AllTransactionsDTO.class)
                .addMappings(mapper -> mapper.map(src -> src.getDate().toString(), AllTransactionsDTO::setDate))
                .addMappings(mapper -> mapper.map(src -> src.getSourceAccount().getAccountNumber().concat("-")
                        .concat(src.getSourceAccount().getAccountDigit()), AllTransactionsDTO::setSourceAccount))
                .addMappings(mapper -> mapper.map(src -> src.getTargetAccount().getAccountNumber().concat("-")
                        .concat(src.getTargetAccount().getAccountDigit()), AllTransactionsDTO::setTargetAccount));
        return mapper;
    }
}