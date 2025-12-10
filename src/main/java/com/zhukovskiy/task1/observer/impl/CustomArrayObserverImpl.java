package com.zhukovskiy.task1.observer.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.entity.CustomArrayData;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.observer.CustomArrayObserver;
import com.zhukovskiy.task1.service.CustomArrayCalculationService;
import com.zhukovskiy.task1.service.impl.CustomArrayCalculationServiceImpl;
import com.zhukovskiy.task1.warehouse.CustomArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayObserverImpl implements CustomArrayObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void updateWarehouseData(CustomArray array) throws CustomArrayException {
        CustomArrayCalculationService calculationService = new CustomArrayCalculationServiceImpl();

        double min = calculationService.findMin(array);
        double max = calculationService.findMax(array);
        double sum = calculationService.calculateSum(array);

        CustomArrayData data = new CustomArrayData(min, max, sum);
        CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
        warehouse.put(array.getId(), data);

        logger.info("Updated arrayData: {} ", array);
    }
}
