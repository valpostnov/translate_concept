package com.postnov.android.translate.words;

import com.postnov.android.translate.base.BasePresenter;
import com.postnov.android.translate.data.source.study.entity.Word;

/**
 * Created by platon on 25.07.2016.
 */
public interface WordsPresenter extends BasePresenter<WordsView> {
    void getAllWords();
    void getFilteredWords(String filter);
    void delete(Word word);
    void deleteAll();
}
