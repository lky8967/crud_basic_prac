package com.example.crud_basic_prac.login;

import com.example.crud_basic_prac.jwt.JwtTokenProvider;
import com.example.crud_basic_prac.user.User;
import com.example.crud_basic_prac.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public String login(LoginRequestDto loginRequestDto) {
//        User user = userRepository.findByUsername(loginRequestDto.getUsername()).orElseThrow(
//                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.");
        User user = userRepository.findByUsername(loginRequestDto.getUsername()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        System.out.println("user = " + user);
//        if (user != null) {
//        if (passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
        if (loginRequestDto.getPassword().equals(user.getPassword())) {
            String token = jwtTokenProvider.createToken(user.getUsername() ,user.getNickname(), user.getId() );
            return token;
//            }
        } else {
            throw new IllegalArgumentException("사용자가 존재하지 않습니다");
        }
//        throw new IllegalArgumentException("오류!");
    }
}
