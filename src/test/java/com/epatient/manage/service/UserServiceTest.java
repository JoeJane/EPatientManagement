package com.epatient.manage.service;

import com.epatient.manage.model.Role;
import com.epatient.manage.model.User;
import com.epatient.manage.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

/**
 * EPatient starter class
 * Author: Jane Aarthy
 * Created on : 10/12/2022
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
        User user = new User(1, "admin", "password", Role.ADMIN);
        doReturn(Optional.of(user)).when(repository).findById(1);

        // Execute the service call
        Optional<User> returnedUser = service.findById(1);

        // Assert the response
        Assertions.assertTrue(returnedUser.isPresent(), "User was not found");
        Assertions.assertSame(returnedUser.get(), user, "The User returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(1);

        // Execute the service call
        Optional<User> returnedUser = service.findById(1);

        // Assert the response
        Assertions.assertFalse(returnedUser.isPresent(), "User should not be found");
    }

    @Test
    @DisplayName("Test findUserByUsername Success")
    void testFindUserByUsername() {
        // Setup our mock repository
        User user = new User(1, "admin", "password", Role.ADMIN);
        doReturn(Optional.of(user)).when(repository).findUserByUsername("admin");

        // Execute the service call
        Optional<User> returnedUser = service.findUserByUsername("admin");

        // Assert the response
        Assertions.assertTrue(returnedUser.isPresent(), "User was not found");
        Assertions.assertSame(returnedUser.get(), user, "The User returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findUserByUsername Not Found")
    void testFindUserByUsernameNotFound() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findUserByUsername("admin");

        // Execute the service call
        Optional<User> returnedUser = service.findUserByUsername("admin");

        // Assert the response
        Assertions.assertFalse(returnedUser.isPresent(), "User should not be found");
    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
        User user1 = new User(1, "admin", "password", Role.ADMIN);
        User user2 = new User(2, "jane", "password", Role.NURSE);
        doReturn(Arrays.asList(user1, user2)).when(repository).findAll();

        // Execute the service call
        List<User> users = service.findAll();

        // Assert the response
        Assertions.assertEquals(2, users.size(), "findAll should return 2 users");
    }

    @Test
    @DisplayName("Test findByRole")
    void testFindByRole() {
        // Setup our mock repository
        User user1 = new User(1, "admin", "password", Role.NURSE);
        User user2 = new User(2, "jane", "password", Role.NURSE);
        doReturn(Arrays.asList(user1, user2)).when(repository).findByRole(Role.NURSE);

        // Execute the service call
        List<User> users = service.findByRole(Role.NURSE);

        // Assert the response
        Assertions.assertEquals(2, users.size(), "findByRole should return 2 users");
    }

    @Test
    @DisplayName("Test findByRoleNot")
    void testFindByRoleNot() {
        // Setup our mock repository
        User user1 = new User(1, "admin", "password", Role.NURSE);
        User user2 = new User(2, "jane", "password", Role.ADMIN);
        doReturn(Arrays.asList(user1)).when(repository).findByRole(Role.ADMIN);

        // Execute the service call
        List<User> users = service.findByRole(Role.ADMIN);

        // Assert the response
        Assertions.assertEquals(1, users.size(), "findByRole should return 2 users");
    }
}
