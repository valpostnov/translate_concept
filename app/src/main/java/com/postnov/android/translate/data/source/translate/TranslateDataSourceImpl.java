package com.postnov.android.translate.data.source.translate;

import com.postnov.android.translate.api.DictionaryApi;
import com.postnov.android.translate.data.source.translate.entity.Response;

import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by platon on 24.07.2016.
 */
public class TranslateDataSourceImpl implements ITranslateDataSource {

    private static final String ENDPOINT = "https://dictionary.yandex.net/api/v1/dicservice.json/";
    private DictionaryApi api;

    public TranslateDataSourceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        api = retrofit.create(DictionaryApi.class);
    }

    @Override
    public Observable<Response> getTranslate(Map<String, String> options) {
        return api.getTranslate(options);
    }
}
