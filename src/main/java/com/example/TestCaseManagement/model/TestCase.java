package com.example.TestCaseManagement.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "test_cases")
public class TestCase {

    @Id
    private String id;

    private String title;
    private String description;
    private Status status;
    private Priority priority;
    
    private Date createdAt;
    private Date updatedAt;
}
