package com.zhukovskiy.task1.parser.Impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.factory.CustomArrayFactory;
import com.zhukovskiy.task1.parser.CustomArrayParser;
import com.zhukovskiy.task1.validator.CustomArrayValidator;
import com.zhukovskiy.task1.validator.Impl.CustomArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayParserImpl implements CustomArrayParser {
    private static final Logger logger = LogManager.getLogger();
    private final CustomArrayValidator validator;
    private final CustomArrayFactory factory;

    public CustomArrayParserImpl(CustomArrayValidator validator, CustomArrayFactory factory) {
        this.validator = validator;
        this.factory = factory;
    }

    @Override
    public CustomArray parseLineToCustomArray(String line) throws CustomArrayException {
        logger.debug("Parsing CustomArray line: {}", line);
        String stripped = line.strip();

        if (stripped.isBlank()) {
            return factory.createEmptyCustomArray();
        }

        if (!validator.isValidCustomArrayLine(stripped)) {
            throw new CustomArrayException("Invalid array line format: " + line);
        }

        double[] array = parseStringToDoubleArray(stripped);
        return factory.createFromArrayCustomArray(array);
    }

    public double[] parseStringToDoubleArray(String line) throws CustomArrayException {
        logger.debug("Parsing line: {}", line);
        String[] parts = line.split("[,;\\-/\\s]+");
        List<String> numberStrings = new ArrayList<>();
        for (String part : parts) {
            String stripped = part.strip();
            if (!stripped.isBlank()) {
                numberStrings.add(stripped);
            }
        }

        double[] result = new double[numberStrings.size()];
        for (int i = 0; i < numberStrings.size(); ++i) {
            try {
                result[i] = Double.parseDouble(numberStrings.get(i));
            } catch (NumberFormatException e) {
                throw new CustomArrayException("Invalid number: " + numberStrings.get(i));
            }
        }

        return result;
    }
}
