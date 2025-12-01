package com.zhukovskiy.task1.service;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;

public interface CustomArrayFindingService {
    public double findMin(CustomArray array) throws CustomArrayException;
    public double findMax(CustomArray array)  throws CustomArrayException;
}
