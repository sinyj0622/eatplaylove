package com.eatplaylove.controller;

import com.eatplaylove.domain.User;
import com.eatplaylove.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/api/join")
    public void save(@RequestBody User user){

        System.out.println(" 되나ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ "  );
        userRepository.save(user);
    }

}
