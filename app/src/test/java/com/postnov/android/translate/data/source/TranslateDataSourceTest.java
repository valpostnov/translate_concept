package com.postnov.android.translate.data.source;

import com.postnov.android.translate.data.source.translate.ITranslateDataSource;
import com.postnov.android.translate.data.source.translate.Options;
import com.postnov.android.translate.data.source.translate.TranslateRemoteDataSource;
import com.postnov.android.translate.data.source.translate.entity.Response;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import rx.observers.TestSubscriber;

/**
 * Created by platon on 24.07.2016.
 */
public class TranslateDataSourceTest {
    private ITranslateDataSource remoteSource;
    private Map<String, String> options;

    @Before
    public void init() {
        remoteSource = new TranslateRemoteDataSource();
        options = Options.create("ru-en", "Россия");
    }

    @Test
    public void test()
    {
        TestSubscriber<Response> subscriber = new TestSubscriber<>();
        remoteSource.getTranslate(options).subscribe(subscriber);
        subscriber.assertNoErrors();
    }
}
