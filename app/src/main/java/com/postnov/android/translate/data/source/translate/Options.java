package com.postnov.android.translate.data.source.translate;

import com.postnov.android.translate.BuildConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by platon on 24.07.2016.
 */
public final class Options {
    private Map<String, String> options;

    private Options(String lang, String text) {
        options = new HashMap<>();
        options.put("key", getKey());
        options.put("lang", lang);
        options.put("text", text);
    }

    private String getKey() {
        return BuildConfig.dictionary_key;
    }

    public static Map<String, String> create(String lang, String text) {
        return new Options(lang, text).options;
    }
}
