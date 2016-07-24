package com.postnov.android.translate.data.source.translate;

import com.postnov.android.translate.data.source.translate.entity.Response;

import java.util.Map;

import rx.Observable;

/**
 * Created by platon on 24.07.2016.
 */
public interface ITranslateDataSource {
    Observable<Response> getTranslate(Map<String, String> options);
}
