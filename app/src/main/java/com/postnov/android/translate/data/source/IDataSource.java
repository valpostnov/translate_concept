package com.postnov.android.translate.data.source;

import com.postnov.android.translate.data.entity.Response;

import java.util.Map;

import rx.Observable;

/**
 * Created by platon on 24.07.2016.
 */
public interface IDataSource {
    Observable<Response> getTranslate(Map<String, String> options);
}
