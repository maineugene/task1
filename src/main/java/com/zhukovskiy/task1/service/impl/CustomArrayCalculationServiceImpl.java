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

        if (customArray == null){
            logger.error("Custom array is null");
            throw new CustomArrayException("Array cannot be null");
        }

        if(customArray.isEmpty()){
            logger.error("Custom array is empty");
            throw new CustomArrayException("Array cannot be empty");
        }

        double sum = 0;
        for(int i = 0; i < customArray.length(); ++i){
            sum += customArray.getValueByIndex(i);
        }

        logger.info("Sum calculated: {} for array size: {}", sum, customArray.length());
        return sum;
    }
}
