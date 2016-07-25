package com.postnov.android.translate.data.source.study.query;

import com.postnov.android.translate.data.source.study.table.WordsTable;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by platon on 25.07.2016.
 */
public class WordsQuery {

    private static final Query.CompleteBuilder builder = Query.builder().table(WordsTable.TABLE_NAME);

    public static Query queryAll() {
        return builder.build();
    }

    public static Query queryUnstudied(int iterations) {

        StringBuilder where = new StringBuilder();
        where.append(WordsTable.COLUMN_CORRECT_ANSWERS);
        where.append(" < ");
        where.append(iterations);

        builder.where(where.toString());
        return builder.build();
    }

    public static Query queryCategory(String category) {

        StringBuilder where = new StringBuilder();
        where.append(WordsTable.COLUMN_CATEGORY);
        where.append(" = ");
        where.append(category);

        builder.where(where.toString());
        return builder.build();
    }
}
