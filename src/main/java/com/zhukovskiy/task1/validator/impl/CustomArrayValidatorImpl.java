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
    private static final String Line_REGEX = "^[\\d\\s.,;+\\-]*$";

    public boolean isValidFile(String filePath) {
        logger.debug("Validating file: {}", filePath);

        Path path = Paths.get(filePath);

        if (filePath.isBlank() || !Files.exists(path) || !Files.isReadable(path)) {
            logger.error("File cannot be read: {}", filePath);
            return false;
        }

        logger.info("File validation passed: {}", filePath);
        return true;
    }

    public boolean isValidCustomArrayLine(String line) {
        String stripped_line = line.strip();

        if (stripped_line.isBlank()) {
            return true;
        }

        boolean isValid = stripped_line.matches(Line_REGEX);

        if (isValid) {
            logger.info("Line {} is valid", line);
        } else {
            logger.info("Line {} is not valid", line);
        }

        return isValid;
    }


}
