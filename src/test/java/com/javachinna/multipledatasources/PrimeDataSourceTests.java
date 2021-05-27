package com.javachinna.multipledatasources;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javachinna.model.prime.Role;
import com.javachinna.model.prime.User;
import com.javachinna.model.prime.UserInfo;
import com.javachinna.repo.prime.RoleRepository;
import com.javachinna.repo.prime.UserInfoRepository;
import com.javachinna.repo.prime.UserRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class PrimeDataSourceTests {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@BeforeAll
	public void init() {
		Role userRole = roleRepository.save(new Role(Role.USER));
		userRepository.save(new User("test", "secret", Set.of(userRole)));
	}

	@Test
	public void getUserTest() {
		List<User> list = userRepository.findAll();
		assertThat(list).isNotEmpty();
	}

	@Test
	public void getUserInfoTest() {
		List<UserInfo> list = userInfoRepository.getUerInfo();
		assertThat(list).isNotEmpty();
		assertThat(list.get(0).getName()).isEqualTo("test");
	}

}
