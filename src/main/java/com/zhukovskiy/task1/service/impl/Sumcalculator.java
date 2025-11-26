package com.zhukovskiy.task1.service.impl;

import com.zhukovskiy.task1.service.CustomArraySumCalculator;

public class Sumcalculator implements CustomArraySumCalculator {
  @Override
  public double calculateSum(double[] array) {
    double sum = 0;
    for(double value : array){
      sum += value;
    }
    return sum;
  }
}
