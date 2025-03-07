package com.first.Sign_in.repository;

import com.first.Sign_in.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
