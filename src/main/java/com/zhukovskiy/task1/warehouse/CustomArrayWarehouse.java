package com.zhukovskiy.task1.warehouse;

import com.zhukovskiy.task1.entity.CustomArray;

public interface CustomArrayWarehouse {
    static CustomArrayWarehouse getInstance();

    boolean containsId(long id);

    void add(CustomArray array);

    void remove(long id);
}
