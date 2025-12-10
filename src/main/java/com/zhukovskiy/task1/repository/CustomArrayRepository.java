package com.zhukovskiy.task1.repository;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.entity.CustomArrayData;
import com.zhukovskiy.task1.exception.CustomArrayException;
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

    private CustomArrayRepository() {
        storage = new ArrayList<>();
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

        storage.add(array);
        //todo update warehouse
        logger.info("Array : {} successfully added.", array);
    }

    void remove(long id) throws CustomArrayException {
        if (!containsId(id)) {
            throw new CustomArrayException("Cannot remove array that does not exists");
        }

        Optional<CustomArray> arrayToRemove = findBySpecification(new FindByIdSpecification(id));
        storage.remove(arrayToRemove);
        CustomArrayWarehouse.getInstance().remove(id);

        logger.info("Array ID {} successfully removed", id);
    }

    Optional<CustomArray> findBySpecification(CustomArraySpecification specification) {
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

    List<CustomArray> sort(Comparator<CustomArray> comparator) {
    }

    public boolean containsId(long id) {
        return CustomArrayWarehouse.getInstance().containsId(id);
    }
}
