package com.zhukovskiy.task1.service;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;

public interface CustomArraySortingService {
    public CustomArray quickSort(CustomArray array) throws CustomArrayException;
    public CustomArray mergeSort(CustomArray array) throws CustomArrayException;
}
