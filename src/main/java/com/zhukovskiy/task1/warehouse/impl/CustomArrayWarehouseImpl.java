package com.zhukovskiy.task1.warehouse.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.warehouse.CustomArrayWarehouse;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouseImpl implements CustomArrayWarehouse {
    private static CustomArrayWarehouse instance;
    private final Map<Long, CustomArray> storage;

    private CustomArrayWarehouseImpl() {
        storage = new HashMap<>();
    }

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouseImpl();
        }
        return instance;
    }

    @Override
    public boolean containsId(long id) {
        return storage.containsKey(id);
    }

    @Override
    public void add(CustomArray array) {
        if (array == null) {
            throw new IllegalArgumentException("Cannot add null array");
        }

        if (storage.containsKey(array.getId())) {
            throw new IllegalArgumentException(
                    "Array with id " + array.getId() + " already exists");
        }

        storage.put(array.getId(), array);
    }

    @Override
    public void remove(long id) {
        storage.remove(id);
    }
}
