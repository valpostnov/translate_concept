package com.postnov.android.translate.data.source.study.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.postnov.android.translate.data.source.study.table.WordsTable;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

/**
 * Created by platon on 24.07.2016.
 */
@StorIOSQLiteType(table = WordsTable.TABLE_NAME)
public class Word implements Parcelable {

    @StorIOSQLiteColumn(name = WordsTable.COLUMN_ID, key = true)
    long id;

    @StorIOSQLiteColumn(name = WordsTable.COLUMN_CATEGORY)
    String category;

    @StorIOSQLiteColumn(name = WordsTable.COLUMN_ORIGINAL)
    String original;

    @StorIOSQLiteColumn(name = WordsTable.COLUMN_TRANSLATE)
    String translate;

    @StorIOSQLiteColumn(name = WordsTable.COLUMN_CORRECT_ANSWERS)
    int correctAnswers;

    @StorIOSQLiteColumn(name = WordsTable.COLUMN_INCORRECT_ANSWERS)
    int incorrectAnswers;

    public Word() {}

    protected Word(Parcel in) {
        category = in.readString();
        original = in.readString();
        translate = in.readString();
        correctAnswers = in.readInt();
        incorrectAnswers = in.readInt();
    }

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getOriginal() {
        return original;
    }

    public String getTranslate() {
        return translate;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
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
