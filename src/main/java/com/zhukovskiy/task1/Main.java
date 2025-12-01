package com.zhukovskiy.task1;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.factory.CustomArrayFactory;
import com.zhukovskiy.task1.factory.impl.CustomArrayFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws CustomArrayException {
        CustomArrayFactory customArrayFactory = new CustomArrayFactoryImpl();
        CustomArray customArray = customArrayFactory.createEmptyCustomArray();
        logger.info(customArray);
    }
}
