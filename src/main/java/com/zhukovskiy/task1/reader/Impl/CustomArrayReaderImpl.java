package com.zhukovskiy.task1.reader.Impl;

import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.parser.CustomArrayParser;
import com.zhukovskiy.task1.reader.CustomArrayReader;
import com.zhukovskiy.task1.validator.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CustomArrayReaderImpl implements CustomArrayReader {
    private static final Logger logger = LogManager.getLogger();
    private final CustomArrayValidator validator;

    public CustomArrayReaderImpl(CustomArrayValidator validator) {
        this.validator = validator;
    }

    @Override
    public String[] readAllLinesFromFile(String filePath) throws CustomArrayException {
        logger.debug("Reading all lines from file: {}", filePath);

        Path path = Paths.get(filePath);

        if (!validator.isValidFile(filePath)) {
            throw new CustomArrayException("File validation failed: {}" + filePath);
        }

        try {
            List<String> lines = Files.readAllLines(path);
            logger.info("Successfully read lines from file: {}", filePath);
            return lines.toArray(new String[0]);
        } catch (IOException e) {
            logger.error("Error reading file: {}", filePath, e);
            throw new CustomArrayException("Cannot read file: " + filePath, e);
        }
    }
}
