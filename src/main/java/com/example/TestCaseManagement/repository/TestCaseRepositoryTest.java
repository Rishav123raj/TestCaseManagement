package com.example.TestCaseManagement.repository;

import com.example.TestCaseManagement.model.Priority;
import com.example.testmTestCaseManagementanagement.model.Status;
import com.example.TestCaseManagement.model.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class TestCaseRepositoryTest {

    @Autowired
    private TestCaseRepository testCaseRepository;

    @Test
    void testSaveAndFindById() {
        TestCase testCase = new TestCase(null, "API Test", "API testing",
                Status.PASSED, Priority.MEDIUM, new Date(), new Date());
        TestCase savedTestCase = testCaseRepository.save(testCase);

        assertNotNull(savedTestCase.getId());
        assertEquals("API Test", savedTestCase.getTitle());
    }

    @Test
    void testFindByStatusAndPriority() {
        testCaseRepository.save(new TestCase(null, "Unit Test", "Unit testing",
                Status.PENDING, Priority.HIGH, new Date(), new Date()));

        List<TestCase> results = testCaseRepository.findByStatusAndPriority(Status.PENDING, Priority.HIGH);
        assertFalse(results.isEmpty());
        assertEquals(1, results.size());
    }
}
