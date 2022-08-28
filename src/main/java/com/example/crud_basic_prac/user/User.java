package com.example.crud_basic_prac.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String passwordCk;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String nickname;

    public User(String username ,String password ,String passwordCk , String email , String nickname){
        this.username = username;
        this.password = password;
        this.passwordCk = passwordCk;
        this.email = email;
        this.nickname = nickname;
    }


}
