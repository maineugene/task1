package com.zhukovskiy.task1.factory;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;

public interface CustomArrayFactory {
    CustomArray createEmptyCustomArray(final long id) throws CustomArrayException;
    CustomArray createWithSizeCustomArray(int size, long id) throws CustomArrayException;
    CustomArray createFilledWithValueCustomArray(int size, int value, long id) throws CustomArrayException;
    CustomArray createFromArrayCustomArray(double[] array, long id) throws CustomArrayException;
}
