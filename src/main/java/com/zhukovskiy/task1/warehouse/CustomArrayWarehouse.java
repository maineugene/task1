package com.zhukovskiy.task1.warehouse;

import com.zhukovskiy.task1.entity.CustomArrayData;
import com.zhukovskiy.task1.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouse {
    private static final Logger logger = LogManager.getLogger();
    private static CustomArrayWarehouse instance;
    private final Map<Long, CustomArrayData> storage;

    private CustomArrayWarehouse() {
        storage = new HashMap<>();
    }

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouse();
        }
        return instance;
    }

    public boolean containsId(long id) {
        return storage.containsKey(id);
    }

    public CustomArrayData get(long id) {
        return storage.get(id);
    }

    public void put(Long id, CustomArrayData arrayData) throws CustomArrayException {
        if (arrayData == null) {
            throw new CustomArrayException("Cannot add null array");
        }

        storage.put(id, arrayData);
    }

    public void remove(long id) {
        if(!containsId(id)){
            logger.warn("Attempt to delete non-existent Id");
        }
        storage.remove(id);
    }
}
