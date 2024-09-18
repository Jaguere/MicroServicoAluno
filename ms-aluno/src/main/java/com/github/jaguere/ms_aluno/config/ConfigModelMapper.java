package com.github.jaguere.ms_aluno.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigModelMapper {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
