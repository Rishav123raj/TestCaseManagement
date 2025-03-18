package com.example.TestCaseManagement.controller;

import com.example.TestCaseManagement.dto.TestCaseDTO;
import com.example.TestCaseManagement.model.TestCase;
import com.example.TestCaseManagement.service.TestCaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private static final Logger logger = LoggerFactory.getLogger(TestCaseController.class);

    @Autowired
    private TestCaseService service;

    @GetMapping
    public List<TestCase> getAllTestCases(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String status, 
        @RequestParam(required = false) String priority) {
        
        logger.info("Fetching test cases with filters: status={}, priority={}", status, priority);
        return service.getAllTestCases(page, size, status, priority);
    }

    @GetMapping("/{id}")
    public TestCase getTestCaseById(@PathVariable String id) {
        logger.info("Fetching test case by ID: {}", id);
        return service.getTestCaseById(id);
    }

    @PostMapping
    public TestCase createTestCase(@Valid @RequestBody TestCaseDTO testCaseDTO) {
        logger.info("Received request to create a test case");
        return service.createTestCase(testCaseDTO);
    }

    @PutMapping("/{id}")
    public TestCase updateTestCase(@PathVariable String id, @Valid @RequestBody TestCaseDTO testCaseDTO) {
        logger.info("Received request to update test case with ID: {}", id);
        return service.updateTestCase(id, testCaseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTestCase(@PathVariable String id) {
        logger.warn("Received request to delete test case with ID: {}", id);
        service.deleteTestCase(id);
    }
}
