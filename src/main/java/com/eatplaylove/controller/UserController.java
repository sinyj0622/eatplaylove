package com.eatplaylove.controller;

import com.eatplaylove.domain.Member;
//import com.eatplaylove.repository.UserRepository;
import com.eatplaylove.domain.User;
import com.eatplaylove.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
//    @GetMapping
//    public List<User> list(){
//        return userRepository.findAll();
//    }
//
//    @PostMapping
//    public void save(@RequestBody Member user){
//        userRepository.save(user);
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Member> findById(@PathVariable("id") Long id){
//        return userRepository.findById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable("id") Long id){
//         userRepository.deleteById(id);
//    }

}
