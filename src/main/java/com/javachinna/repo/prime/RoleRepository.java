package com.javachinna.repo.prime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javachinna.model.prime.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
