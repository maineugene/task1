package com.zhukovskiy.task1;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.factory.CustomArrayFactory;
import com.zhukovskiy.task1.factory.impl.CustomArrayFactoryImpl;
import com.zhukovskiy.task1.parser.CustomArrayParser;
import com.zhukovskiy.task1.parser.impl.CustomArrayParserImpl;
import com.zhukovskiy.task1.reader.CustomArrayReader;
import com.zhukovskiy.task1.reader.impl.CustomArrayReaderImpl;
import com.zhukovskiy.task1.validator.CustomArrayValidator;
import com.zhukovskiy.task1.validator.impl.CustomArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String PATH = "data/parameters.txt";
    public static void main(String[] args) throws CustomArrayException {
    }
}
