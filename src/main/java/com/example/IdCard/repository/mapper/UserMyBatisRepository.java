package com.example.IdCard.repository.mapper;

import com.example.IdCard.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMyBatisRepository {

    void insert(User user);
    Optional<User> findByUsername(@Param("username") String username);

}
