package com.zhukovskiy.task1.validator.Impl;

import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.validator.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomArrayValidatorImpl implements CustomArrayValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String Line_REGEX = "^[\\d\\s.,;+\\-]*$";

    public boolean isValidFile(String filePath) throws CustomArrayException {
        logger.debug("Validating file: {}", filePath);

        if (filePath == null || filePath.isBlank()) {
            throw new CustomArrayException("File path cannot be null or blank");
        }

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new CustomArrayException("File does not exist: " + filePath);
        }

        if (!Files.isReadable(path)) {
            throw new CustomArrayException("File is not readable: " + filePath);
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
