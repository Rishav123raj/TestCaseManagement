package com.example.TestCaseManagement.utils;

import com.example.TestCaseManagement.dto.TestCaseDTO;
import com.example.TestCaseManagement.model.TestCase;

import java.util.Date;

public class TestCaseFactory {
    public static TestCase createTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = new TestCase();
        testCase.setTitle(testCaseDTO.getTitle());
        testCase.setDescription(testCaseDTO.getDescription());
        testCase.setStatus(testCaseDTO.getStatus());
        testCase.setPriority(testCaseDTO.getPriority());
        testCase.setCreatedAt(new Date());
        testCase.setUpdatedAt(new Date());
        return testCase;
    }
}
