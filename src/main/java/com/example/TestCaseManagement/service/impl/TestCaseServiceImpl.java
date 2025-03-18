package com.example.testmanagement.service.impl;

import com.example.testmanagement.dto.TestCaseDTO;
import com.example.testmanagement.model.*;
import com.example.testmanagement.repository.TestCaseRepository;
import com.example.testmanagement.service.TestCaseService;
import com.example.testmanagement.utils.TestCaseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    private static final Logger logger = LoggerFactory.getLogger(TestCaseServiceImpl.class);
    private static TestCaseServiceImpl instance;

    @Autowired
    private TestCaseRepository repository;

    private TestCaseServiceImpl() {}

    public static synchronized TestCaseServiceImpl getInstance() {
        if (instance == null) {
            instance = new TestCaseServiceImpl();
        }
        return instance;
    }

    @Override
    public List<TestCase> getAllTestCases(int page, int size, String status, String priority) {
        logger.info("Fetching test cases with pagination - Page: {}, Size: {}", page, size);
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public TestCase getTestCaseById(String id) {
        logger.info("Fetching test case with ID: {}", id);
        return repository.findById(id).orElseThrow(() -> {
            logger.error("Test case not found: {}", id);
            return new RuntimeException("TestCase Not Found");
        });
    }

    @Override
    public TestCase createTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = TestCaseFactory.createTestCase(testCaseDTO);
        logger.info("Creating new test case: {}", testCase.getTitle());
        return repository.save(testCase);
    }

    @Override
    public TestCase updateTestCase(String id, TestCaseDTO testCaseDTO) {
        TestCase existingTestCase = getTestCaseById(id);
        existingTestCase.setTitle(testCaseDTO.getTitle());
        existingTestCase.setDescription(testCaseDTO.getDescription());
        existingTestCase.setStatus(testCaseDTO.getStatus());
        existingTestCase.setPriority(testCaseDTO.getPriority());
        existingTestCase.setUpdatedAt(new Date());
        logger.info("Updating test case: {}", id);
        return repository.save(existingTestCase);
    }

    @Override
    public void deleteTestCase(String id) {
        logger.warn("Deleting test case with ID: {}", id);
        repository.deleteById(id);
    }
}
