package com.example.IdCard.service;

import com.example.IdCard.model.dto.request.LoginRequest;
import com.example.IdCard.model.dto.response.LoginResponse;
import com.example.IdCard.model.dto.response.RegisterResponse;
import com.example.IdCard.model.dto.request.RegisterRequest;
import com.example.IdCard.model.entity.User;

import java.util.Optional;

public interface UserService {
 RegisterResponse register(RegisterRequest registerRequest);

 LoginResponse login(LoginRequest loginRequest);

 Optional<User> getUserByUsername(String username);
}
