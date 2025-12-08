package com.zhukovskiy.task1.comparator;

import com.zhukovskiy.task1.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayIdComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
