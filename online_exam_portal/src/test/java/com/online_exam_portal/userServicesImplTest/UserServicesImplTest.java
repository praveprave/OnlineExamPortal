package com.online_exam_portal.userServicesImplTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.examportal.OnlineExamPortalApplication;
import com.examportal.dto.UserDto;
import com.examportal.entity.User;
import com.examportal.repository.UserRepository;
import com.examportal.serviceimpl.UserServicesImpl;
import com.examportal.exception.UserNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import com.examportal.entity.User;
import com.examportal.exception.UserNotFoundException;
import com.examportal.repository.UserRepository;
import com.examportal.serviceimpl.UserServicesImpl;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = OnlineExamPortalApplication.class)
@ExtendWith(MockitoExtension.class)
class UserServicesImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRepository mockUserRepository;


    @InjectMocks
    private UserServicesImpl userServices;
   

    @Test
    void testLogin_Successful() {
        // Mocking data
        String userMail = "test@example.com";
        String userPassword = "password";
        User mockUser = new User();
        mockUser.setUserMail(userMail);
        mockUser.setUserPassword(userPassword);

        // Mocking repository behavior
        lenient().when(userRepository.findByUserMailAndUserPassword(anyString(), anyString())).thenReturn(mockUser);

        // Call the method to be tested
        User result = userServices.login(userMail, userPassword);

        // Verify that the repository method was called with the correct arguments
        verify(userRepository, times(1)).findByUserMailAndUserPassword(userMail, userPassword);

        // Verify the result
        assertEquals(mockUser, result, "Login should be successful");
    }

    @Test
    void testLogin_Failure_UserNotFound() {
        // Mocking data
        String userMail = "nonexistent@example.com";
        String userPassword = "wrongPassword";

        // Mocking repository behavior (returning null to simulate user not found)
        lenient().when(userRepository.findByUserMailAndUserPassword(anyString(), anyString())).thenReturn(null);

        // Call the method to be tested
        User result = userServices.login(userMail, userPassword);

        // Verify that the repository method was called with the correct arguments
        verify(userRepository, times(1)).findByUserMailAndUserPassword(userMail, userPassword);

        // Verify the result (should be null)
        assertEquals(null, result, "Login should fail. User not found.");
    }
    @Test
    void testCreateUser() {
        // Mocking data
        UserDto userDto = new UserDto();
        userDto.setUserId(101);
        userDto.setUserName("John Doe");
        userDto.setUserPassword("password123");
        userDto.setUserMail("john@example.com");
        userDto.setMobileNo(1234567890);
        userDto.setUserAddress("123 Main St");

        // Mocking repository behavior
        when(userRepository.save(any(User.class))).thenReturn(createMockUser(userDto));

        // Call the method to be tested
        User createdUser = userServices.createUser(userDto);

        // Verify that the repository method was called with the correct argument
        verify(userRepository, times(1)).save(any(User.class));

        // Verify the result
        assertNotNull(createdUser, "Created user should not be null");
        assertEquals(userDto.getUserId(), createdUser.getUserId(), "User ID should match");
        assertEquals(userDto.getUserName(), createdUser.getUserName(), "User name should match");
        assertEquals(userDto.getUserPassword(), createdUser.getUserPassword(), "User password should match");
        assertEquals(userDto.getUserMail(), createdUser.getUserMail(), "User email should match");
        assertEquals(userDto.getMobileNo(), createdUser.getMobileNo(), "User mobile number should match");
        assertEquals(userDto.getUserAddress(), createdUser.getUserAddress(), "User address should match");
    }

    private User createMockUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserMail(userDto.getUserMail());
        user.setMobileNo(userDto.getMobileNo());
        user.setUserAddress(userDto.getUserAddress());
        return user;
    }

    @Test
    void testUpdateUser() {
        // Mocking data
        int userId = 1;
        UserDto userDto = new UserDto();
        userDto.setUserName("Updated Name");
        userDto.setMobileNo(987654321);
        userDto.setUserMail("updated@example.com");
        userDto.setUserAddress("456 Updated St");

        // Mocking repository behavior
        User existingUser = createMockUser(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(existingUser);

        // Call the method to be tested
        assertDoesNotThrow(() -> userServices.updateUser(userId, userDto));

        // Verify that the repository methods were called with the correct arguments
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(any(User.class));

        // Verify the result
        assertEquals(userDto.getUserName(), existingUser.getUserName(), "User name should be updated");
        assertEquals(userDto.getMobileNo(), existingUser.getMobileNo(), "User mobile number should be updated");
        assertEquals(userDto.getUserMail(), existingUser.getUserMail(), "User email should be updated");
        assertEquals(userDto.getUserAddress(), existingUser.getUserAddress(), "User address should be updated");
    }

    @Test
    void testUpdateUser_UserNotFound() {
        // Mocking data
        int userId = 1;
        UserDto userDto = new UserDto();
        userDto.setUserName("Updated Name");

        // Mocking repository behavior for user not found
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Call the method to be tested and expect UserNotFoundException
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> userServices.updateUser(userId, userDto));

        // Verify that the exception message is correct
        assertEquals("User not found with Id:" + userId, exception.getMessage());

        // Verify that the repository method was called with the correct argument
        verify(userRepository, times(1)).findById(userId);
        // Ensure that save was not called
        verify(userRepository, never()).save(any(User.class));
    }

    private User createMockUser(int userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("John Doe");
        user.setMobileNo(1234567890);
        user.setUserMail("john@example.com");
        user.setUserAddress("123 Main St");
        return user;
    }

    @Test
    void testDeleteUser_UserNotFound() {
        // Setup and repository mocking
        Integer userId = 1; // assuming some userId
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Test the deleteUser method
        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> userServices.deleteUser(userId));

        // Optionally, you can assert the exception message or other details
        assertEquals("User not found with ID: " + userId, exception.getMessage());
    }
    @Test
    void testGetAllUsers() {
        // Mocking data
        User user1 = new User(1, "John Doe", "john.doe@example.com", 0, "password123", null);
        User user2 = new User(2, "Jane Doe", "jane.doe@example.com", 0, "password456", null);

        // Mocking the UserRepository to return a list of users
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Testing the getAllUsers method
        List<User> result = userServices.getAllUsers();

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());

        // You can add more specific assertions based on your User class properties
        assertEquals(user1.getUserId(), result.get(0).getUserId());
        assertEquals(user2.getUserName(), result.get(1).getUserName());

        // Verify that the userRepository.findAll() method was called once
        verify(userRepository, times(1)).findAll();
    }
    @Test
    void testGetUserById_UserFound() {
        // Mocking data
        User mockUser = new User(1, "John Doe", "john.doe@example.com", 0, "password123", null);

        // Mocking the UserRepository
        when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));

        // Testing the getUserById method
        User result = userServices.getUserById(1);

        // Assertions...
    }
}