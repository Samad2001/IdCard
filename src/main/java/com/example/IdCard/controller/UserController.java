package com.example.IdCard.controller;

import com.example.IdCard.exception.ErrorDetails;
import com.example.IdCard.model.dto.response.LoginResponse;
import com.example.IdCard.model.dto.response.RegisterResponse;
import com.example.IdCard.model.dto.request.LoginRequest;
import com.example.IdCard.model.dto.request.RegisterRequest;
import com.example.IdCard.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse registerResponse = userService.register(registerRequest);
        return ResponseEntity.ok(registerResponse);
    }


    @Operation(description = "for login and get token") //apinin ne ucun oldugunu yaziriq
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "400", description = "bad request with detail",

            content = @Content(
                        schema = @Schema(implementation = ErrorDetails.class),
                    examples = @ExampleObject(name = "user not exist", value = )
            )),

            @ApiResponse(responseCode = "500", description = "internal server error")
    }
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}
