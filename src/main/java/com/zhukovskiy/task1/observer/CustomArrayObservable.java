package com.zhukovskiy.task1.observer;

public interface CustomArrayObservable {
    void addObserver(CustomArrayObservable observable);
    void removeObserver(CustomArrayObservable observable);
    void notifyObserver(CustomArrayObservable observable);
}
