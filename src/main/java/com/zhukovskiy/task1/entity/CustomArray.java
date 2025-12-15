package com.zhukovskiy.task1.entity;

import com.zhukovskiy.task1.exception.CustomArrayException;
import com.zhukovskiy.task1.observer.CustomArrayObservable;
import com.zhukovskiy.task1.observer.CustomArrayObserver;
import com.zhukovskiy.task1.observer.impl.CustomArrayObserverImpl;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray implements CustomArrayObservable{

    private final long id;
    private double[] array;

    private CustomArrayObserver observer;

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
        notifyObserver();
    }

    public void setValueByIndex(final int index, final double value) throws CustomArrayException {
        if (index < 0 || index >= array.length) {
            throw new CustomArrayException("Index " + index + " out of bounds for size " + array.length);
        }
        array[index] = value;
        notifyObserver();
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

    @Override
    public void addObserver(CustomArrayObserver observer) {
        this.observer = observer;
    }

    @Override
    public void removeObserver(CustomArrayObserver observer) {
        if (this.observer == observer) {
            this.observer = null;
        }
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            observer.updateWarehouseData(this);
        }
    }
}
