package com.eatplaylove.repository;

import com.eatplaylove.domain.Member;
import com.eatplaylove.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}