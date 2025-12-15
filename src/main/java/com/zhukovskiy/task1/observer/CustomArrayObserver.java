package com.zhukovskiy.task1.observer;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;

public interface CustomArrayObserver {
    void updateWarehouseData(CustomArray array);
}
