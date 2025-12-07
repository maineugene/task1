package com.zhukovskiy.task1.factory.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.factory.CustomArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class CustomArrayFactoryImpl implements CustomArrayFactory {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray createEmptyCustomArray(final long id) throws CustomArrayException {
        logger.debug("Starting empty CustomArray creation");
        logger.info("Empty CustomArray created");
        return new CustomArray(0, id);
    }

    @Override
    public CustomArray createWithSizeCustomArray(int size, final long id) throws CustomArrayException{
        logger.debug("Starting custom array creation with size: {}", size);

        if(size < 0){
            logger.error("Invalid array size provided: {}", size);
            throw new CustomArrayException("Array size cannot be negative:" + size);
        }
        CustomArray result = new CustomArray(size, id);
        logger.info("CustomArray created successfully with size: {}", size);
        return result;
    }

    @Override
    public CustomArray createFilledWithValueCustomArray(int size, int value, long id) throws CustomArrayException{
        logger.debug("Starting custom array creation with size: {} and values: {}", size, value);

        if (size < 0) {
            logger.error("Invalid array size provided: {}", size);
            throw new CustomArrayException("Array size cannot be negative: " + size);
        }

        CustomArray result = new CustomArray(size, value, id);
        logger.info("CustomArray created successfully with size: {}, filled with value: {}", size, value);
        return result;
    }

    @Override
    public CustomArray createFromArrayCustomArray(double[] array, long id) throws CustomArrayException {
        logger.debug("Starting custom array creation with array: {}", array);

        if(array == null){
            logger.error("Source array cannot be null");
            throw new CustomArrayException("Source array cannot be null");
        }

        CustomArray result = new CustomArray(array, id);
        logger.info("CustomArray created successfully with array: {}", array);
        return result;
    }
}
