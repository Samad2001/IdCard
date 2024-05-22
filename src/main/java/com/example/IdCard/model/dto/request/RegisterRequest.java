package com.example.IdCard.model.dto.request;


import lombok.Data;

@Data
public class RegisterRequest {
    private String  username;
    private String  password;
    private String  confirmPassword;
    private String  name;
    private String  surname;
}
