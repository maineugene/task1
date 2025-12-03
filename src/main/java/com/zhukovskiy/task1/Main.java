package com.zhukovskiy.task1;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.factory.CustomArrayFactory;
import com.zhukovskiy.task1.factory.impl.CustomArrayFactoryImpl;
import com.zhukovskiy.task1.parser.CustomArrayParser;
import com.zhukovskiy.task1.parser.Impl.CustomArrayParserImpl;
import com.zhukovskiy.task1.reader.CustomArrayReader;
import com.zhukovskiy.task1.reader.Impl.CustomArrayReaderImpl;
import com.zhukovskiy.task1.validator.CustomArrayValidator;
import com.zhukovskiy.task1.validator.Impl.CustomArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String PATH = "data/parametrs.txt";
    public static void main(String[] args) throws CustomArrayException {
        CustomArrayFactory customArrayFactory = new CustomArrayFactoryImpl();
        CustomArrayValidator validator= new CustomArrayValidatorImpl();
        CustomArrayReader customArrayReader = new CustomArrayReaderImpl(validator);
        CustomArrayParser parser = new CustomArrayParserImpl(validator, customArrayFactory);

        logger.info("Reading file: {}", PATH);
        String[] lines = customArrayReader.readAllLinesFromFile(PATH);
        logger.info("Parsing {} lines", lines.length);
        for(String line: lines){
            try {
                CustomArray customArray = parser.parseLineToCustomArray(line);
                logger.info("CustomArray: {}", customArray);
            } catch (CustomArrayException e) {
                logger.warn("Failed to parse line {}:{}", line, e.getMessage());
            }
        }


    }
}
