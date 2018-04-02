package com.webback.persistence.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webback.domain.User;
import com.webback.persistence.service.UserPersistenceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/test-datasource.xml")
public class UserPersistenceTest {

	private static final String NAME = "GREGOR";

	private static final String USERNAME = "gregor";

	private static final String PASS = "pass";

	private static final String SALT = "salt";

	@Autowired
	private UserPersistenceService userPersistenceService;

	@Test
	public void createUserTest() {

		// Setup
		final User expectedUser = new User();
		expectedUser.setName(NAME);
		expectedUser.setUsername(USERNAME);
		expectedUser.setPassword(PASS);
		expectedUser.setSalt(SALT);

		// Test
		final User actualUser = userPersistenceService
				.createUser(expectedUser);

		assertThat(actualUser.getUserId(), greaterThan(0L));
		assertEquals(expectedUser.getName(), actualUser.getName());
		assertEquals(expectedUser.getUsername(), actualUser.getUsername());
		assertEquals(expectedUser.getPassword(), actualUser.getPassword());
		assertEquals(expectedUser.getSalt(), actualUser.getSalt());

		userPersistenceService.deleteUserByUsername(actualUser);
	}

	@Test
	public void deleteUserByUsernameTest() {

		// Setup
		final User inputUser = new User();
		inputUser.setName(NAME);
		inputUser.setUsername(USERNAME);
		inputUser.setPassword(PASS);
		inputUser.setSalt(SALT);

		userPersistenceService
				.createUser(inputUser);

		// Test
		final Long userResult = userPersistenceService
				.deleteUserByUsername(inputUser);

		assertThat(userResult, greaterThan(0L));
	}

	@Test
	public void readUserByUsernameTest() {

		// Setup
		final User inputUser = new User();
		inputUser.setName(NAME);
		inputUser.setUsername(USERNAME);
		inputUser.setPassword(PASS);
		inputUser.setSalt(SALT);

		final User expectedUser = userPersistenceService
				.createUser(inputUser);

		// Test
		final User actualUser = userPersistenceService
				.readUserByUsername(inputUser);

		assertEquals(expectedUser.getUserId(), actualUser.getUserId());
		assertEquals(expectedUser.getName(), actualUser.getName());
		assertEquals(expectedUser.getUsername(), actualUser.getUsername());
		assertEquals(expectedUser.getPassword(), actualUser.getPassword());
		assertEquals(expectedUser.getSalt(), actualUser.getSalt());

		userPersistenceService.deleteUserByUsername(actualUser);
	}
}
