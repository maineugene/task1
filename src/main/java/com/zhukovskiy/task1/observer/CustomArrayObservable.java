package com.zhukovskiy.task1.observer;

public interface CustomArrayObservable {
    void addObserver(CustomArrayObserver observer);
    void removeObserver(CustomArrayObserver observer);
    void notifyObserver();
}
