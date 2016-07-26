package com.anhvurz90.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anhvurz90.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
