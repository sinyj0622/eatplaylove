package com.eatplaylove.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eatplaylove.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String username);
}