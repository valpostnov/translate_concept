package com.postnov.android.translate.api;

import com.postnov.android.translate.data.source.translate.entity.Response;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by platon on 23.07.2016.
 */
public interface DictionaryApi {
    @GET("lookup")
    Observable<Response> getTranslate(@QueryMap Map<String, String> options);
}