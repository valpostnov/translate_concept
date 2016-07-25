package com.postnov.android.translate.data.source.study.table;

import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by platon on 25.07.2016.
 */
public class StatisticsTable {

    public static final String TABLE_NAME = "statistics";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_STUDIED_WORDS = "studied_words";
    public static final String COLUMN_UNSTUDIED_WORDS = "unstudied_words";
    public static final String COLUMN_SUCCESS_TASKS = "success_tasks";

    private StatisticsTable() {
        throw new IllegalStateException("No instances please");
    }

    public static String getCreateTableQuery() {

        return "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY, " +
                COLUMN_DATE + " TEXT NOT NULL, " +
                COLUMN_STUDIED_WORDS + " INTEGER NOT NULL, " +
                COLUMN_UNSTUDIED_WORDS + " INTEGER NOT NULL, " +
                COLUMN_SUCCESS_TASKS + " INTEGER NOT NULL );";
    }
}
