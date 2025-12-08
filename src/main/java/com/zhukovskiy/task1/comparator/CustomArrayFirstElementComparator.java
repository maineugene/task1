package com.zhukovskiy.task1.comparator;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;

import java.util.Comparator;

public class CustomArrayFirstElementComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        if (o1.isEmpty() && o2.isEmpty()) return 0;
        if (o1.isEmpty()) return -1;
        if (o2.isEmpty()) return 1;

        return Double.compare(o1.getValueByIndex(0), o2.getValueByIndex(0));
    }
}
