package com.example.crud_basic_prac.login;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/api/users/login")
    public ResponseEntity<String> login(final HttpServletResponse response, @RequestBody LoginRequestDto loginRequestDto) {
        String login = loginService.login(loginRequestDto);
        System.out.println("###################################### login = " + login);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
}
