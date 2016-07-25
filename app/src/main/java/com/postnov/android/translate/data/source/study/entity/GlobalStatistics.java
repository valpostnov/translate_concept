package com.postnov.android.translate.data.source.study.entity;

import java.util.List;

/**
 * Created by platon on 25.07.2016.
 */
public class GlobalStatistics {

    private List<Statistics> weekStatistics;
    private int unstudiedWords;

    public GlobalStatistics(List<Statistics> weekStatistics, int unstudiedWords) {
        this.weekStatistics = weekStatistics;
        this.unstudiedWords = unstudiedWords;
    }

    public List<Statistics> getWeekStatistics() {
        return weekStatistics;
    }

    public int getUnstudiedWords() {
        return unstudiedWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlobalStatistics that = (GlobalStatistics) o;

        if (unstudiedWords != that.unstudiedWords) return false;

        return weekStatistics.equals(that.weekStatistics);
    }

    @Override
    public int hashCode() {
        int result = weekStatistics.hashCode();
        result = 31 * result + unstudiedWords;

        return result;
    }
}
