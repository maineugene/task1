package com.zhukovskiy.task1.validator;

import com.zhukovskiy.task1.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;

public interface CustomArrayValidator {
    public boolean isValidFile(String filepath);

    public boolean isValidCustomArrayLine(String line);
}
