package com.zhukovskiy.task1.factory;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;

public interface CustomArrayFactory {
    CustomArray createEmptyCustomArray() throws CustomArrayException;
    CustomArray createWithSizeCustomArray(int size) throws CustomArrayException;
    CustomArray createFilledWithValueCustomArray(int size, int value) throws CustomArrayException;
    CustomArray createFromArrayCustomArray(double[] array) throws CustomArrayException;
}
