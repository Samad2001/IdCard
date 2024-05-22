package com.example.IdCard.mapper;

import com.example.IdCard.model.dto.request.RegisterRequest;
import com.example.IdCard.model.entity.User;
import com.example.IdCard.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "createdAt",expression = "java(LocalDateTime.now())")
    User toUser(RegisterRequest registerRequest);

}
