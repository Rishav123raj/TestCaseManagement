package com.example.TestCaseManagement.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediumPriorityStrategy implements PriorityStrategy {
    private static final Logger logger = LoggerFactory.getLogger(MediumPriorityStrategy.class);

    @Override
    public void applyPriority() {
        logger.info("Applying MEDIUM priority strategy for test cases.");
    }
}
