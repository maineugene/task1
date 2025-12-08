package com.zhukovskiy.task1.repository;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface CustomArrayRepository {
    void add(CustomArray array) throws CustomArrayException;

    void update(long id, CustomArray array) throws CustomArrayException;

    void delete(long id) throws CustomArrayException;

    Optional<CustomArray> find(long id);

    List<CustomArray> sort(Comparator<CustomArray> comparator);
}
