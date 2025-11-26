package com.zhukovskiy.task1.service.impl;

import com.zhukovskiy.task1.service.CustomArraySorter;

public class QuickSorter implements CustomArraySorter {
  @Override
  public double[] sort(double[] array) {
    double[] result = java.util.Arrays.copyOf(array, array.length);
    quickSort(result, 0, result.length - 1);
    return result;
  }

  private void quickSort(double[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  private int partition(double[] arr, int low, int high) {
    double pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (arr[j] <= pivot) {
        i++;
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    double temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }
}
