package com.eatplaylove.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eatplaylove.jwt.dto.MemberLoginRequestDto;
import com.eatplaylove.service.MemberService;
import com.eatplaylove.jwt.dto.TokenDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public TokenDto login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {
        String memberId = memberLoginRequestDto.getMemberId();
        String password = memberLoginRequestDto.getPassword();
        TokenDto tokenDto = memberService.login(memberId, password);
        return tokenDto;
    }

    @PostMapping("/test")
    public String test() {
        return "sucess";
    }
}
