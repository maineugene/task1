package com.zhukovskiy.task1.entity;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray {

    private double[] array;

    public CustomArray(final int size){
        this.array = new double[size];
    }

    public CustomArray(double[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public CustomArray(int size, double value){
        this.array = new double[size];
        for (int i = 0; i < size; i++) {
            this.array[i] = value;
        }
    }

    public double[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(double[] array){
        this.array = Arrays.copyOf(array, array.length);
    }

    public double getValueByIndex(final int index){
        return array[index];
    }

    public void setValueByIndex(final int index, final double value){
        array[index] = value;
    }

    public int length(){
        return array.length;
    }

    public boolean isEmpty(){
        return array.length == 0;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomArray.class.getSimpleName() + "[", "]")
                .add("array=" + Arrays.toString(array))
                .toString();
    }
}
