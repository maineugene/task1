package com.zhukovskiy.task1.validator.impl;

import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.validator.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomArrayValidatorImpl implements CustomArrayValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String LINE_REGEX = "^[\\d\\s.,;+\\-]*$";

    public boolean isValidCustomArrayLine(String line) {
        String strippedLine = line.strip();

        if (strippedLine.isBlank()) {
            return true;
        }

        boolean isValid = strippedLine.matches(LINE_REGEX);
        logger.debug("Line {} is {}", line, isValid ? "valid" : "invalid");

        return isValid;
    }
}
