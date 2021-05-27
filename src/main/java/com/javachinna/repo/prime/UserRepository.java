package com.javachinna.repo.prime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javachinna.model.prime.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String userName);
}
