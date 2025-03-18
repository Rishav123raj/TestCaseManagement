package com.example.TestCaseManagement.service;

import com.example.testmanagement.dto.TestCaseDTO;
import com.example.testmanagement.model.TestCase;
import java.util.List;

public interface TestCaseService {
    List<TestCase> getAllTestCases(int page, int size, String status, String priority);
    TestCase getTestCaseById(String id);
    TestCase createTestCase(TestCaseDTO testCaseDTO);
    TestCase updateTestCase(String id, TestCaseDTO testCaseDTO);
    void deleteTestCase(String id);
}
