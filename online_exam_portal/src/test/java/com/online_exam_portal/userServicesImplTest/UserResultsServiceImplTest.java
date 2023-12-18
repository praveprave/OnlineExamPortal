package com.examportal.serviceimpltest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.examportal.OnlineExamPortalApplication;
import com.examportal.dto.UserDashBoardDto;
import com.examportal.entity.User;
import com.examportal.entity.UserResults;
import com.examportal.repository.TestRepository;
import com.examportal.repository.UserRepository;
import com.examportal.repository.UserResultsRepository;
import com.examportal.serviceimpl.UserResultsServiceImpl;

// Add other necessary imports
@SpringBootTest
@ContextConfiguration(classes = OnlineExamPortalApplication.class)
@ExtendWith(MockitoExtension.class)
public class UserResultsServiceImplTest {

    @InjectMocks
    private UserResultsServiceImpl userResultsService;

    @Mock
    private UserResultsRepository userResultsRepository;

    @Mock
    private TestRepository testRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetUserDashBoard() {
        // Mocking user
        User user = new User();
        user.setUserId(1);

        // Mocking exam results
        List<UserResults> examResults = new ArrayList<>();
        UserResults userResults = new UserResults();
        userResults.setExamScore(80);
        examResults.add(userResults);

        // Mocking available tests
        List<com.examportal.entity.Test> availableTests = new ArrayList<>();
        com.examportal.entity.Test test1 = new com.examportal.entity.Test();
        test1.setTestId(101);
        test1.setCourseType("Java");
        availableTests.add(test1);

        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
        when(userResultsRepository.findByUser_UserId(1)).thenReturn(examResults);
        when(testRepository.findAll()).thenReturn(availableTests);

        // Test the method
        UserDashBoardDto userDashBoardDto = userResultsService.getUserDashBoard(1);

        // Assertions
        assertEquals(1, userDashBoardDto.getUserId());
        assertEquals(80, userDashBoardDto.getExamScore());
        assertEquals(LocalDate.now(), userDashBoardDto.getExamDate());
        assertEquals(1, userDashBoardDto.getAvailableTestsDtolist().size());
        assertEquals(101, userDashBoardDto.getAvailableTestsDtolist().get(0).getTestId());
        assertEquals("Java", userDashBoardDto.getAvailableTestsDtolist().get(0).getCourseType());
    }

    // Add more test cases as needed
}