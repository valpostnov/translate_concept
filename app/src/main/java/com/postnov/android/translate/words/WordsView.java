package com.postnov.android.translate.words;

import com.postnov.android.translate.base.BaseView;
import com.postnov.android.translate.data.source.study.entity.Word;

import java.util.List;

/**
 * Created by platon on 25.07.2016.
 */
public interface WordsView extends BaseView {
    void showAllWords(List<Word> words);
    void showFilteredWords(List<Word> words);
    void showInfo(String message);
}
