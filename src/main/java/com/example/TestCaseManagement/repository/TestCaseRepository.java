package com.example.TestCaseManagement.repository;

import com.example.testmanagement.model.TestCase;
import com.example.testmanagement.model.Status;
import com.example.testmanagement.model.Priority;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestCaseRepository extends MongoRepository<TestCase, String> {
    List<TestCase> findByStatusAndPriority(Status status, Priority priority);
}
