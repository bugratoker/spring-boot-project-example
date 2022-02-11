package com.toker.alpbugra.config;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

    //instance oluşturmasını sağlayan Bean anotasyonu
    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper =
               new  ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
