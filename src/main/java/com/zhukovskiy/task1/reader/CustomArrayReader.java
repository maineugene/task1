package com.zhukovskiy.task1.reader;

import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.validator.CustomArrayValidator;

public interface CustomArrayReader {
    String[] readAllLinesFromFile(String filepath) throws CustomArrayException;
}
