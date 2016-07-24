package com.postnov.android.translate.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by platon on 24.07.2016.
 */
public class Task implements Parcelable {

    private long uid;
    private String type;
    private int status;
    private int studiedWords;
    private int unstudiedWords;

    public Task() {}

    protected Task(Parcel in) {
        uid = in.readLong();
        type = in.readString();
        status = in.readInt();
        studiedWords = in.readInt();
        unstudiedWords = in.readInt();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(uid);
        parcel.writeString(type);
        parcel.writeInt(status);
        parcel.writeInt(studiedWords);
        parcel.writeInt(unstudiedWords);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (uid != task.uid) return false;
        if (status != task.status) return false;
        if (studiedWords != task.studiedWords) return false;
        if (unstudiedWords != task.unstudiedWords) return false;

        return type.equals(task.type);
    }

    @Override
    public int hashCode() {
        int result = (int) (uid ^ (uid >>> 32));
        result = 31 * result + type.hashCode();
        result = 31 * result + status;
        result = 31 * result + studiedWords;
        result = 31 * result + unstudiedWords;

        return result;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        string.append("[ uid: ");
        string.append(uid);
        string.append(", type: ");
        string.append(type);
        string.append(", status: ");
        string.append(status);
        string.append(" (studied words: ");
        string.append(studiedWords);
        string.append(", unstudied words: ");
        string.append(unstudiedWords);
        string.append(") ]");

        return string.toString();
    }
}
