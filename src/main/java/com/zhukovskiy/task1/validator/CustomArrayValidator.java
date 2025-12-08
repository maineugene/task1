package com.zhukovskiy.task1.validator;

import com.zhukovskiy.task1.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;

public interface CustomArrayValidator {
    boolean isValidFile(String filepath);

    boolean isValidCustomArrayLine(String line);
}
