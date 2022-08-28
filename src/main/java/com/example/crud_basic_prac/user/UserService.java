package com.example.crud_basic_prac.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void userRegister(UserRequestDto userRequestDto) {

        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();
        String passwordCk = userRequestDto.getPasswordCk();
        String email = userRequestDto.getEmail();
        String nickname = userRequestDto.getNickname();


        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }
        if(!password.equals(passwordCk)){
            throw new IllegalArgumentException("비밀번호를 다시 확인해 주세요.");
        }
        
        User user = new User(username, password, passwordCk , email , nickname);

        userRepository.save(user);

    }
}
