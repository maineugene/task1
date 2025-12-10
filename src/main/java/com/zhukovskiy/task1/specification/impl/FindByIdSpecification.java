package com.zhukovskiy.task1.specification.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.specification.CustomArraySpecification;

public class FindByIdSpecification implements CustomArraySpecification {
    private final long targetId;

    public FindByIdSpecification(long targetId) {
        this.targetId = targetId;
    }

    @Override
    public boolean matches(CustomArray customArray) {
        return targetId == customArray.getId();
    }
}
