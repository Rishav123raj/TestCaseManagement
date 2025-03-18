package com.example.TestCaseManagement.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HighPriorityStrategy implements PriorityStrategy {
    private static final Logger logger = LoggerFactory.getLogger(HighPriorityStrategy.class);

    @Override
    public void applyPriority() {
        logger.info("Applying HIGH priority strategy for test cases.");
    }
}
