package com.postnov.android.translate.data.source.study.table;

/**
 * Created by platon on 25.07.2016.
 */
public class WordsTable {

    public static final String TABLE_NAME = "words";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ORIGINAL = "original";
    public static final String COLUMN_TRANSLATE = "translate";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_CORRECT_ANSWERS = "correct_answers";
    public static final String COLUMN_INCORRECT_ANSWERS = "incorrect_answers";

    private WordsTable() {
        throw new IllegalStateException("No instances please");
    }

    public static String getCreateTableQuery() {

        return "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY, " +
                COLUMN_CATEGORY + " TEXT NOT NULL, " +
                COLUMN_ORIGINAL + " TEXT NOT NULL, " +
                COLUMN_TRANSLATE + " TEXT NOT NULL, " +
                COLUMN_CORRECT_ANSWERS + " INTEGER NOT NULL, " +
                COLUMN_INCORRECT_ANSWERS + " INTEGER NOT NULL );";
    }
}
