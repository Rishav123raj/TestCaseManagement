package com.example.TestCaseManagement.controller;

import com.example.TestCaseManagement.dto.TestCaseDTO;
import com.example.TestCaseManagement.model.Priority;
import com.example.TestCaseManagement.model.Status;
import com.example.TestCaseManagement.model.TestCase;
import com.example.TestCaseManagement.repository.TestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestCaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestCaseRepository testCaseRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private TestCase testCase;

    @BeforeEach
    void setUp() {
        testCaseRepository.deleteAll();
        testCase = testCaseRepository.save(new TestCase(null, "Integration Test", "API integration test",
                Status.PENDING, Priority.HIGH, new Date(), new Date()));
    }

    @Test
    void testGetTestCaseById() throws Exception {
        mockMvc.perform(get("/api/testcases/" + testCase.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Integration Test"));
    }

    @Test
    void testCreateTestCase() throws Exception {
        TestCaseDTO testCaseDTO = new TestCaseDTO();
        testCaseDTO.setTitle("New Test");
        testCaseDTO.setDescription("New API test");
        testCaseDTO.setStatus(Status.IN_PROGRESS);
        testCaseDTO.setPriority(Priority.LOW);

        mockMvc.perform(post("/api/testcases")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testCaseDTO)))
                .andExpect(status().isOk());
    }
}