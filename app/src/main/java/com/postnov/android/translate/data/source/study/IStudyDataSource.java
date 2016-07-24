package com.postnov.android.translate.data.source.study;

import com.postnov.android.translate.data.source.study.entity.Statistics;
import com.postnov.android.translate.data.source.study.entity.Word;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;

import java.util.List;

import rx.Observable;

/**
 * Created by platon on 24.07.2016.
 */
public interface IStudyDataSource {

    Observable<List<Word>> getWords(int count);
    Observable<Statistics> getDayStatistics(String date);
    Observable<List<Statistics>> getSomeDaysStatistics(int count);

    Observable<PutResult> saveWord(Word word);
    Observable<DeleteResult> deleteWord(String word);
    Observable<PutResult> updateWord(Word word);
    Observable<PutResult> saveDayStatistics(Statistics statistics);
    Observable<DeleteResult> deleteDayStatistics(Statistics statistics);
}
