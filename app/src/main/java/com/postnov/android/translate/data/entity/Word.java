package com.postnov.android.translate.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by platon on 24.07.2016.
 */
public class Word implements Parcelable {

    private String category;
    private String original;
    private String translate;
    private int correctAnswers;
    private int incorrectAnswers;

    public Word() {}

    protected Word(Parcel in) {
        category = in.readString();
        original = in.readString();
        translate = in.readString();
        correctAnswers = in.readInt();
        incorrectAnswers = in.readInt();
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(category);
        parcel.writeString(original);
        parcel.writeString(translate);
        parcel.writeInt(correctAnswers);
        parcel.writeInt(incorrectAnswers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (correctAnswers != word.correctAnswers) return false;
        if (incorrectAnswers != word.incorrectAnswers) return false;
        if (!category.equals(word.category)) return false;
        if (!original.equals(word.original)) return false;

        return translate.equals(word.translate);
    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + original.hashCode();
        result = 31 * result + translate.hashCode();
        result = 31 * result + correctAnswers;
        result = 31 * result + incorrectAnswers;

        return result;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        string.append("[ ");
        string.append(category);
        string.append(": ");
        string.append(original);
        string.append("->");
        string.append(translate);
        string.append(" (correct answers: ");
        string.append(correctAnswers);
        string.append(", incorrect answers: ");
        string.append(incorrectAnswers);
        string.append(") ]");

        return string.toString();
    }
}
