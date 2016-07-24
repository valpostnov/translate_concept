package com.postnov.android.translate.data.source.study;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.postnov.android.translate.data.source.study.table.StatisticsTable;
import com.postnov.android.translate.data.source.study.table.WordsTable;

/**
 * Created by platon on 24.07.2016.
 */
public class StudyDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "study.db";

    public StudyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WordsTable.getCreateTableQuery());
        db.execSQL(StatisticsTable.getCreateTableQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
