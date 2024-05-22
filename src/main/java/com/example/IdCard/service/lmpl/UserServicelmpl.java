package com.example.IdCard.service.lmpl;

import com.example.IdCard.exception.CommonException;
    import com.example.IdCard.mapper.UserMapper;
import com.example.IdCard.model.dto.request.LoginRequest;
import com.example.IdCard.model.dto.response.LoginResponse;
import com.example.IdCard.model.dto.response.RegisterResponse;
import com.example.IdCard.model.dto.request.RegisterRequest;
import com.example.IdCard.model.entity.User;
import com.example.IdCard.repository.mapper.UserMyBatisRepository;
import com.example.IdCard.service.UserService;
import com.example.IdCard.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServicelmpl implements UserService {

    private final UserMyBatisRepository userRepository;
    private  final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<User> userOptional = getUserByUsername(loginRequest.getUsername());

        if (userOptional.isEmpty()) {
            throw new CommonException("1000", "user not exist in database", HttpStatus.BAD_REQUEST);
//            return LoginResponse.withResponse("user is not exist");
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        authenticationManager.authenticate(authenticationToken);

        String token = jwtProvider.generateToken(userOptional.get());
        return LoginResponse.withToken(token);
    }


    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if (!Objects.equals(registerRequest.getPassword(), registerRequest.getConfirmPassword())) {
            throw new CommonException("1001", "passwords and confirm password not matched", HttpStatus.BAD_REQUEST);
//            return new RegisterResponse("passwords_not_matched");
        }

        Optional<User> byUsernameOptional =userRepository.findByUsername(registerRequest.getUsername());

        if (byUsernameOptional.isPresent()){
            return new RegisterResponse("duplicate_username");
        }

        User user = userMapper.toUser(registerRequest);
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        userRepository.insert(user);
        return new RegisterResponse("success");
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
