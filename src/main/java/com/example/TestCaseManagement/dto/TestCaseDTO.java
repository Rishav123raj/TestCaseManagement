package com.example.TestCaseManagement.dto;

import lombok.Data;
import com.example.testmanagement.model.Status;
import com.example.testmanagement.model.Priority;
import javax.validation.constraints.NotBlank;

@Data
public class TestCaseDTO {
    
    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private Status status;
    private Priority priority;
}
