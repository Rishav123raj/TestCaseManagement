package com.example.TestCaseManagement.service;

import com.example.TestCaseManagement.dto.TestCaseDTO;
import com.example.TestCaseManagement.model.Priority;
import com.example.TestCaseManagement.model.Status;
import com.example.TestCaseManagement.model.TestCase;
import com.example.TestCaseManagement.repository.TestCaseRepository;
import com.example.TestCaseManagement.service.impl.TestCaseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestCaseServiceTest {

    @Mock
    private TestCaseRepository testCaseRepository;

    @InjectMocks
    private TestCaseServiceImpl testCaseService;

    private TestCase testCase;
    private TestCaseDTO testCaseDTO;

    @BeforeEach
    void setUp() {
        testCase = new TestCase("1", "Login Test", "Test login feature",
                Status.PENDING, Priority.HIGH, new Date(), new Date());

        testCaseDTO = new TestCaseDTO();
        testCaseDTO.setTitle("Updated Login Test");
        testCaseDTO.setDescription("Updated test");
        testCaseDTO.setStatus(Status.IN_PROGRESS);
        testCaseDTO.setPriority(Priority.MEDIUM);
    }

    @Test
    void testGetTestCaseById_Success() {
        when(testCaseRepository.findById("1")).thenReturn(Optional.of(testCase));
        TestCase result = testCaseService.getTestCaseById("1");
        assertNotNull(result);
        assertEquals("Login Test", result.getTitle());
    }

    @Test
    void testGetTestCaseById_NotFound() {
        when(testCaseRepository.findById("2")).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class, () -> testCaseService.getTestCaseById("2"));
        assertEquals("TestCase Not Found", exception.getMessage());
    }

    @Test
    void testCreateTestCase_Success() {
        when(testCaseRepository.save(any(TestCase.class))).thenReturn(testCase);
        TestCase result = testCaseService.createTestCase(testCaseDTO);
        assertNotNull(result);
        assertEquals("Updated Login Test", result.getTitle());
    }

    @Test
    void testDeleteTestCase() {
        doNothing().when(testCaseRepository).deleteById("1");
        testCaseService.deleteTestCase("1");
        verify(testCaseRepository, times(1)).deleteById("1");
    }
}
