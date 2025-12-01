package com.zhukovskiy.task1.service.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.service.CustomArrayFindingService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CustomArrayFindingServiceImpl implements CustomArrayFindingService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public double findMax(CustomArray customArray) throws CustomArrayException {
        logger.debug("Finding maximum value in array: {}", customArray);

        if(customArray == null){
            logger.error("Custom array is null");
            throw new CustomArrayException("Array cannot be null");
        }

        if(customArray.isEmpty()){
            logger.error("Custom array is empty");
            throw new CustomArrayException("Array cannot be empty");
        }

        double max = Double.NEGATIVE_INFINITY;
        /*double[] arrayCp = customArray.getArray();
        for(double value : arraycp){
            if(value > max){
                max = value;
            }
        }*/
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

        if(customArray == null){
            logger.error("Custom array is null");
            throw new CustomArrayException("Array cannot be null");
        }

        if(customArray.isEmpty()){
            logger.error("Custom array is empty");
            throw new CustomArrayException("Array cannot be empty");
        }

        for (int i = 0; i < customArray.length(); ++i) {
            if (customArray.getValueByIndex(i) < min) {
                min = customArray.getValueByIndex(i);
            }
        }

        logger.info("Minimum value found: {}", min);
        return min;
    }
}
