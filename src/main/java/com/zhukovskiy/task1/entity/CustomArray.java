package com.zhukovskiy.task1.entity;

import com.zhukovskiy.task1.service.CustomArraySorter;

public class CustomArray {
  private double[] array;

  public CustomArray(double[] array) {
    this.array = java.util.Arrays.copyOf(array, array.length);
  }

  public void sort(CustomArraySorter sorter){
    this.array = sorter.sort(this.array);
  }

  public double search4Min(CustomArraySorter sorter){
  }

}
