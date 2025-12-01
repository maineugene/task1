package com.zhukovskiy.task1.service;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;

public interface CustomArrayCalculationService {
    double calculateSum(CustomArray array) throws CustomArrayException;
}
