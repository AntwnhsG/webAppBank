package com.example.testinterview.baseLogger;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseLogger {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void init() {
        logger.trace("Loaded {}.", getClass());
    }

    @PreDestroy
    public void destroy() {
        logger.trace("{} is about to be destroyed.", getClass().getName());
    }
}
