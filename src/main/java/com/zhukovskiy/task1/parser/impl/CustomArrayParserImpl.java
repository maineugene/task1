package com.zhukovskiy.task1.parser.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.factory.CustomArrayFactory;
import com.zhukovskiy.task1.parser.CustomArrayParser;
import com.zhukovskiy.task1.validator.CustomArrayValidator;
import com.zhukovskiy.task1.validator.impl.CustomArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArrayParserImpl implements CustomArrayParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SEPARATOR_REGEX = "[,;\\-/\\s]+";

    @Override
    public double[] parseLineToDoubleArray(String line) throws CustomArrayException {
        logger.debug("Parsing CustomArray line: {}", line);
        CustomArrayValidator validator = new CustomArrayValidatorImpl();

        if (!validator.isValidCustomArrayLine(line)) {
            throw new CustomArrayException("Invalid array line format: " + line);
        }

        String stripped = line.strip();
        if (stripped.isBlank()) {
            return new double[0];
        }

        String[] parts = stripped.split(SEPARATOR_REGEX);
        List<String> numberStrings = new ArrayList<>(Arrays.asList(parts));

        double[] result = new double[numberStrings.size()];
        for (int i = 0; i < numberStrings.size(); ++i) {
            result[i] = Double.parseDouble(numberStrings.get(i));
        }

        return result;
    }
}
