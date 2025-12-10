package com.zhukovskiy.task1.specification.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.entity.CustomArrayData;
import com.zhukovskiy.task1.specification.CustomArraySpecification;
import com.zhukovskiy.task1.warehouse.CustomArrayWarehouse;

public class SumGreaterThanSpecification implements CustomArraySpecification {
    private final double sum;

    public SumGreaterThanSpecification(double sum){
        this.sum = sum;
    }

    @Override
    public boolean matches(CustomArray customArray) {
        long id = customArray.getId();
        CustomArrayData data = CustomArrayWarehouse.getInstance().get(id);
        return data.sum() > sum;
    }
}
