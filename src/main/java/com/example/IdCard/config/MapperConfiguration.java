package com.example.IdCard.config;

import com.example.IdCard.mapper.IdCardMapper;
import com.example.IdCard.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfiguration {

    @Bean
    public IdCardMapper  idCardMapper(){
        return IdCardMapper.INSTANCE;
    }

//    @Bean
//    @Primary
//    public UserMapper UserMapper(){
//        return UserMapper.INSTANCE;
//    }

}
