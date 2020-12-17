package com.example.mmvpmvm.contract;

public interface ICallBack<D> {
    void getSuccess(D d);
    void getFails();
}
