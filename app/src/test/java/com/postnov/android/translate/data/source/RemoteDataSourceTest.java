package com.postnov.android.translate.data.source;

import com.postnov.android.translate.data.entity.Response;
import com.postnov.android.translate.data.source.remote.Options;
import com.postnov.android.translate.data.source.remote.RemoteDataSource;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import rx.observers.TestSubscriber;

/**
 * Created by platon on 24.07.2016.
 */
public class RemoteDataSourceTest {
    private IDataSource remoteSource;
    private Map<String, String> options;

    @Before
    public void init() {
        remoteSource = new RemoteDataSource();
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
