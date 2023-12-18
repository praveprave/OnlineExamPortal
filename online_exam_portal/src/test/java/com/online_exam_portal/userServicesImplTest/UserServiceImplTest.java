package com.examportal.serviceimpltest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.examportal.entity.User;
import com.examportal.exception.InvalidCredentialsException;
import com.examportal.repository.UserRepository;
import com.examportal.serviceimpl.UserServiceImpl;

@SpringBootTest
 class UserServiceImplTest {
	 @Mock
	    private UserRepository userRepository;

	    @InjectMocks
	    private UserServiceImpl userServiceImpl;

	    @Test
	    void testGetAllUser() throws InvalidCredentialsException {
	        // Arrange
	        List<User> userList = new ArrayList<>();
	        userList.add(new User(1, "John Doe", "john@example.com", "password"));
	        userList.add(new User(2, "Jane Doe", "jane@example.com", "password"));

	        when(userRepository.findAll()).thenReturn(userList);

	        // Act
	        List<User> result = userServiceImpl.getAllUser();

	        // Assert
	        assertNotNull(result);
	        assertEquals(2, result.size());
	    }

	    @Test
	    void testGetAllUserNoUsers() {
	        // Arrange
	        when(userRepository.findAll()).thenReturn(new ArrayList<>());

	        // Act and Assert
	        assertThrows(InvalidCredentialsException.class, () -> userServiceImpl.getAllUser());
	    }
	    @Test
	    public void testGetAllAvailableTests() {
	        // Mocking available tests
	        List<Test> availableTests = new ArrayList<>();
	        Test test1 = new Test();
	        test1.setTestId(101);
	        test1.setCourseType("Java");
	        availableTests.add(test1);

	        when(testRepository.findAll()).thenReturn(availableTests);

	        // Call the method
	        List<AvailableTestsDto> result = userResultsService.getAllAvailableTests();

	        // Assertions
	        assertNotNull(result);
	        assertEquals(1, result.size());

	        AvailableTestsDto dto = result.get(0);
	        assertEquals(test1.getTestId(), dto.getTestId());
	        assertEquals(test1.getCourseType(), dto.getCourseType());
	    }
	
}
