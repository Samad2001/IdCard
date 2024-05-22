package com.example.IdCard.model.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;


}
