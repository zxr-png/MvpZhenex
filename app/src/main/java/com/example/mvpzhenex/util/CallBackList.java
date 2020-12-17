package com.example.mvpzhenex.util;

public interface CallBackList<T> {
    void onSecced(T t);
    void onFiale(Error error);
}
