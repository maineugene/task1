package com.zhukovskiy.task1.service.impl;

import com.zhukovskiy.task1.entity.CustomArray;
import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.service.CustomArraySortingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArraySortingServiceImpl implements CustomArraySortingService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray quickSort(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Input array cannot be null");
        }
        if (array.isEmpty()) {
            logger.warn("Quick sort called on empty array");
            return new CustomArray(array.getArray());
        }

        double[] sortedArray = array.getArray().clone();
        quickSort(sortedArray, 0, sortedArray.length - 1);

        logger.info("Quick sort completed for array size: {}", array.length());
        return new CustomArray(sortedArray);
    }

    @Override
    public CustomArray mergeSort(CustomArray array) throws CustomArrayException {
        if (array == null) {
            throw new CustomArrayException("Input array cannot be null");
        }
        if (array.isEmpty()) {
            logger.warn("Merge sort called on empty array");
            return new CustomArray(array.getArray());
        }

        double[] sortedArray = array.getArray().clone();
        mergeSort(sortedArray, 0, sortedArray.length - 1);

        logger.info("Merge sort completed for array size: {}", array.length());
        return new CustomArray(sortedArray);
    }

    private void quickSort(double[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(double[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
