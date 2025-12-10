package com.zhukovskiy.task1.entity;

import com.zhukovskiy.task1.exception.CustomArrayException;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray {

    private final long id;
    private double[] array;

    public CustomArray(final int size, final long id) throws CustomArrayException {
        if (size < 0) {
            throw new CustomArrayException("Size cannot be negative: " + size);
        }

        if (id < 0) {
            throw new CustomArrayException("ID cannot be negative: " + id);
        }

        this.array = new double[size];
        this.id = id;
    }

    public CustomArray(double[] array, final long id) throws CustomArrayException {
        if (id < 0) {
            throw new CustomArrayException("ID cannot be negative: " + id);
        }

        this.array = Arrays.copyOf(array, array.length);
        this.id = id;
    }

    public CustomArray(int size, double value, final long id) throws CustomArrayException {
        if (size < 0) {
            throw new CustomArrayException("Size cannot be negative: " + size);
        }

        if (id < 0) {
            throw new CustomArrayException("ID cannot be negative: " + id);
        }

        this.array = new double[size];
        for (int i = 0; i < size; i++) {
            this.array[i] = value;
        }
        this.id = id;
    }

    public double[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public double getValueByIndex(final int index) throws CustomArrayException {
        if (index < 0 || index >= array.length) {
            throw new CustomArrayException("Index " + index + " out of bounds for size " + array.length);
        }
        return array[index];
    }

    public long getId() {
        return id;
    }

    public void setArray(double[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public void setValueByIndex(final int index, final double value) throws CustomArrayException {
        if (index < 0 || index >= array.length) {
            throw new CustomArrayException("Index " + index + " out of bounds for size " + array.length);
        }
        array[index] = value;
    }

    public int length() {
        return array.length;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;
        return id == that.id && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + Long.hashCode(id);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomArray.class.getSimpleName() + "[", "]")
                .add("array=" + Arrays.toString(array))
                .toString();
    }
}
