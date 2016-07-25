package com.postnov.android.translate.base;

/**
 * Created by platon on 25.07.2016.
 */
public interface BasePresenter<T> {
    void bind(T view);
    void unbind();
    void unsubscribe();
}
