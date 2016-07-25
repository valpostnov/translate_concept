package com.postnov.android.translate.data.source.study.query;

import com.postnov.android.translate.data.source.study.table.StatisticsTable;
import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by platon on 25.07.2016.
 */
public class StatisticsQuery {

    private static final Query.CompleteBuilder builder = Query.builder().table(StatisticsTable.TABLE_NAME);

    public static Query queryAll() {
        return builder.build();
    }

    public static Query queryThisWeek() {
        return builder.build(); // TODO: 25.07.2016 create query
    }

    public static Query queryConcreteDay(String date) {
        return builder.build(); // TODO: 25.07.2016 create query
    }
}
