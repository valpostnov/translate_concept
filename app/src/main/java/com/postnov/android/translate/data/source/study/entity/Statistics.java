package com.postnov.android.translate.data.source.study.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.postnov.android.translate.data.source.study.table.StatisticsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by platon on 24.07.2016.
 */
@StorIOSQLiteType(table = StatisticsTable.TABLE_NAME)
public class Statistics implements Parcelable {

    @StorIOSQLiteColumn(name = StatisticsTable.COLUMN_ID, key = true)
    long id;

    @StorIOSQLiteColumn(name = StatisticsTable.COLUMN_DATE)
    String date;

    @StorIOSQLiteColumn(name = StatisticsTable.COLUMN_STUDIED_WORDS)
    int studiedWords;

    @StorIOSQLiteColumn(name = StatisticsTable.COLUMN_UNSTUDIED_WORDS)
    int unstudiedWords;

    @StorIOSQLiteColumn(name = StatisticsTable.COLUMN_SUCCESS_TASKS)
    int successTasks;

    public Statistics() {}

    protected Statistics(Parcel in) {
        date = in.readString();
        studiedWords = in.readInt();
        unstudiedWords = in.readInt();
        successTasks = in.readInt();
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getStudiedWords() {
        return studiedWords;
    }

    public int getUnstudiedWords() {
        return unstudiedWords;
    }

    public int getSuccessTasks() {
        return successTasks;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStudiedWords(int studiedWords) {
        this.studiedWords = studiedWords;
    }

    public void setUnstudiedWords(int unstudiedWords) {
        this.unstudiedWords = unstudiedWords;
    }

    public void setSuccessTasks(int successTasks) {
        this.successTasks = successTasks;
    }

    public static final Creator<Statistics> CREATOR = new Creator<Statistics>() {
        @Override
        public Statistics createFromParcel(Parcel in) {
            return new Statistics(in);
        }

        @Override
        public Statistics[] newArray(int size) {
            return new Statistics[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
        parcel.writeInt(studiedWords);
        parcel.writeInt(unstudiedWords);
        parcel.writeInt(successTasks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statistics that = (Statistics) o;

        if (studiedWords != that.studiedWords) return false;
        if (unstudiedWords != that.unstudiedWords) return false;
        if (successTasks != that.successTasks) return false;

        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + studiedWords;
        result = 31 * result + unstudiedWords;
        result = 31 * result + successTasks;

        return result;
    }
}
