package com.zhukovskiy.task1.repository.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.warehouse.CustomArrayWarehouse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayRepositoryImpl {
    private static final Logger logger = LogManager.getLogger();
    private static CustomArrayRepositoryImpl instance;
    private final CustomArrayWarehouse warehouse;
    private final List<CustomArray> customArrayList = new ArrayList<>();

    private CustomArrayRepositoryImpl(){
        this.warehouse = CustomArrayWarehouse.getInstance();
    }

    public static CustomArrayRepositoryImpl getInstance(){
        if(instance == null){
            instance = new CustomArrayRepositoryImpl();
        }
        return instance;
    }

    public void add(CustomArray array) throws CustomArrayException {
        if (array == null){
            throw new CustomArrayException("Array cannot be null");
        }

        if(warehouse.containsId(array.getId())){
            throw new CustomArrayException("Array with id " + array.getId() + " already exists");
        }
    }
}
