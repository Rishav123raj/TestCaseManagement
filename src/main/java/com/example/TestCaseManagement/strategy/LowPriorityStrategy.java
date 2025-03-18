package com.example.TestCaseManagement.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowPriorityStrategy implements PriorityStrategy {
    private static final Logger logger = LoggerFactory.getLogger(LowPriorityStrategy.class);

    @Override
    public void applyPriority() {
        logger.info("Applying LOW priority strategy for test cases.");
    }
}
