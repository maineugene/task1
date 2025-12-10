package com.zhukovskiy.task1.service.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.service.CustomArrayCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayCalculationServiceImpl implements CustomArrayCalculationService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public double calculateSum(CustomArray customArray) throws CustomArrayException {
        logger.debug("Calculating sum for custom array: {}", customArray);

        validateArray(customArray, "calculateSum");

        double sum = 0;
        for(int i = 0; i < customArray.length(); ++i){
            sum += customArray.getValueByIndex(i);
        }

        logger.info("Sum calculated: {} for array size: {}", sum, customArray.length());
        return sum;
    }

    @Override
    public double findMax(CustomArray customArray) throws CustomArrayException {
        logger.debug("Finding maximum value in array: {}", customArray);

        validateArray(customArray, "findMax");

        double max = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < customArray.length(); ++i) {
            if (customArray.getValueByIndex(i) > max) {
                max = customArray.getValueByIndex(i);
            }
        }
        logger.info("Maximum value found: {}", max);
        return max;
    }

    public double findMin(CustomArray customArray) throws CustomArrayException {
        double min = Double.POSITIVE_INFINITY;

        logger.debug("Finding minimum value in array: {}", customArray);

        validateArray(customArray, "findMin");

        for (int i = 0; i < customArray.length(); ++i) {
            if (customArray.getValueByIndex(i) < min) {
                min = customArray.getValueByIndex(i);
            }
        }

        logger.info("Minimum value found: {}", min);
        return min;
    }

    private void validateArray(CustomArray customArray, String operation) throws CustomArrayException {
        if (customArray == null){
            logger.error("Custom array is null for operation: {}", operation);
            throw new CustomArrayException("Array cannot be null");
        }

        if(customArray.isEmpty()){
            logger.error("Custom array is empty for operation: {}", operation);
            throw new CustomArrayException("Array cannot be empty");
        }
    }
}
