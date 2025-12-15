package com.zhukovskiy.task1.repository;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.observer.CustomArrayObserver;
import com.zhukovskiy.task1.specification.CustomArraySpecification;
import com.zhukovskiy.task1.specification.impl.FindByIdSpecification;
import com.zhukovskiy.task1.warehouse.CustomArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CustomArrayRepository {
    private static final Logger logger = LogManager.getLogger();
    private static CustomArrayRepository instance;
    private final List<CustomArray> storage;
    private final CustomArrayWarehouse warehouse;

    private CustomArrayRepository() {
        storage = new ArrayList<>();
        warehouse = CustomArrayWarehouse.getInstance();
        logger.info("Repository instance created");
    }

    public static CustomArrayRepository getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepository();
        }
        return instance;
    }

    public void add(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Array cannot be null");
        }

        long id = array.getId();
        if (containsId(id)) {
            logger.info("Array with id: {} already exists", array.getId());
            throw new CustomArrayException("Array with id " + id + " already exists");
        }

        if (warehouse instanceof CustomArrayObserver) {
            array.addObserver((CustomArrayObserver) warehouse);
            logger.debug("Warehouse subscribed as observer for array id: {}", id);
        }

        storage.add(array);
        updateWarehouseData(array);
        logger.info("Array : {} successfully added.", array);
    }

    public void remove(long id) throws CustomArrayException {
        if (!containsId(id)) {
            throw new CustomArrayException("Cannot remove array that does not exists");
        }

        Optional<CustomArray> arrayToRemove = findBySpecification(new FindByIdSpecification(id));
        if (arrayToRemove.isEmpty()) {
            logger.error("Array with ID {} not found in storage but exists in warehouse", id);
            throw new CustomArrayException("Inconsistent state: array not found in storage");
        }

        CustomArray array = arrayToRemove.get();

        if (warehouse instanceof CustomArrayObserver) {
            array.removeObserver((CustomArrayObserver) warehouse);
            logger.debug("Warehouse unsubscribed from array id: {}", id);
        }

        boolean removedFromStorage = storage.remove(array);

        if (!removedFromStorage) {
            logger.error("Failed to remove array with ID {} from storage", id);
            throw new CustomArrayException("Failed to remove array from storage");
        }

        warehouse.remove(id);

        logger.info("Array ID {} successfully removed", id);
    }

    public Optional<CustomArray> findBySpecification(CustomArraySpecification specification) {
        if (specification == null) {
            logger.warn("Null specification provided to findBySpecification");
            return Optional.empty();
        }

        for (CustomArray array : storage) {
            if (specification.matches(array)) {
                return Optional.of(array);
            }
        }

        logger.debug("No arrays found matching specification ");
        return Optional.empty();
    }

    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        if (comparator == null) {
            logger.warn("Null comparator provided to sort method");
            return new ArrayList<>(storage);
        }
        List<CustomArray> sortedList = new ArrayList<>(storage);
        sortedList.sort(comparator);
        logger.info("Repository sorted using comparator: {}", comparator.getClass().getSimpleName());
        return sortedList;
    }

    public boolean containsId(long id) {
        return CustomArrayWarehouse.getInstance().containsId(id);
    }

    private void updateWarehouseData(CustomArray array) {
        try {
            if (warehouse instanceof CustomArrayObserver) {
                ((CustomArrayObserver) warehouse).updateWarehouseData(array);
            }
            logger.debug("Warehouse updated for array id: {}", array.getId());
        } catch (Exception e) {
            logger.error("Failed to update warehouse for array id: {}", array.getId(), e);
        }
    }
}
