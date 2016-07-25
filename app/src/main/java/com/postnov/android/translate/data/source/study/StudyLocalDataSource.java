package com.postnov.android.translate.data.source.study;

import android.database.sqlite.SQLiteOpenHelper;

import com.postnov.android.translate.data.source.study.entity.Statistics;
import com.postnov.android.translate.data.source.study.entity.StatisticsSQLiteTypeMapping;
import com.postnov.android.translate.data.source.study.entity.Word;
import com.postnov.android.translate.data.source.study.entity.WordSQLiteTypeMapping;
import com.postnov.android.translate.data.source.study.query.StatisticsQuery;
import com.postnov.android.translate.data.source.study.query.WordsQuery;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;

import java.util.List;

import rx.Observable;

/**
 * Created by platon on 24.07.2016.
 */
public class StudyLocalDataSource implements IStudyDataSource {

    private StorIOSQLite storIOSQLite;
    private static StudyLocalDataSource sInstance;

    public static StudyLocalDataSource getInstance(SQLiteOpenHelper sqLiteOpenHelper)
    {
        if (sInstance == null) {
            sInstance = new StudyLocalDataSource(sqLiteOpenHelper);
        }

        return sInstance;
    }

    private StudyLocalDataSource(SQLiteOpenHelper sqLiteOpenHelper) {

        storIOSQLite = DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(sqLiteOpenHelper)
                .addTypeMapping(Word.class, new WordSQLiteTypeMapping())
                .addTypeMapping(Statistics.class, new StatisticsSQLiteTypeMapping())
                .build();
    }

    @Override
    public Observable<List<Word>> getWords() {

        return storIOSQLite.get()
                .listOfObjects(Word.class)
                .withQuery(WordsQuery.queryAll())
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<List<Word>> getWords(String category) {

        return storIOSQLite.get()
                .listOfObjects(Word.class)
                .withQuery(WordsQuery.queryCategory(category))
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<List<Word>> getUnstudiedWords(int iterations) {

        return storIOSQLite.get()
                .listOfObjects(Word.class)
                .withQuery(WordsQuery.queryUnstudied(iterations))
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<Statistics> getDayStatistics(String date) {

        return storIOSQLite.get()
                .object(Statistics.class)
                .withQuery(StatisticsQuery.queryConcreteDay(date))
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<List<Statistics>> getWeekStatistics() {

        return storIOSQLite.get()
                .listOfObjects(Statistics.class)
                .withQuery(StatisticsQuery.queryThisWeek())
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<PutResult> saveWord(Word word) {

        return storIOSQLite.put()
                .object(word)
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<DeleteResult> deleteWord(Word word) {

        return storIOSQLite.delete()
                .object(word)
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<DeleteResult> deleteAll() {

        return null;
    }

    @Override
    public Observable<PutResult> updateWord(Word word) {
        return null;
    }

    @Override
    public Observable<PutResult> saveDayStatistics(Statistics statistics) {

        return storIOSQLite.put()
                .object(statistics)
                .prepare()
                .asRxObservable();
    }

    @Override
    public Observable<DeleteResult> deleteDayStatistics(Statistics statistics) {

        return storIOSQLite.delete()
                .object(statistics)
                .prepare()
                .asRxObservable();
    }
}
