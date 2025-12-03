package com.zhukovskiy.task1.parser;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.factory.CustomArrayFactory;
import com.zhukovskiy.task1.validator.CustomArrayValidator;

public interface CustomArrayParser {
    public CustomArray parseLineToCustomArray(String line) throws CustomArrayException;
}
