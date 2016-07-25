package com.postnov.android.translate.words;

import com.postnov.android.translate.data.source.study.IStudyDataSource;
import com.postnov.android.translate.data.source.study.entity.Word;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by platon on 25.07.2016.
 */
public class WordsPresenterImpl implements WordsPresenter {

    private WordsView wordsView;
    private CompositeSubscription subscriptions;
    private IStudyDataSource dataSource;

    public WordsPresenterImpl(IStudyDataSource dataSource) {
        this.dataSource = dataSource;
        subscriptions = new CompositeSubscription();
    }

    @Override
    public void getAllWords() {

        wordsView.showProgress(true);
        subscriptions.add(dataSource.getWords()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError));
    }

    @Override
    public void getFilteredWords(String filter) {

        wordsView.showProgress(true);
        subscriptions.add(dataSource.getWords(filter)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError));
    }

    @Override
    public void delete(Word word) {

        subscriptions.add(dataSource.deleteWord(word)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> { wordsView.showInfo("Deleted: " + result.numberOfRowsDeleted());})
        );
    }

    @Override
    public void deleteAll() {

        subscriptions.add(dataSource.deleteAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(deleteResult -> { wordsView.showInfo("We all die"); })
        );
    }

    @Override
    public void bind(WordsView view) {
        wordsView = view;
    }

    @Override
    public void unbind() {
        wordsView = null;
    }

    @Override
    public void unsubscribe() {
        subscriptions.clear();
    }

    private Action1<List<Word>> onNext = words -> {
        wordsView.showProgress(false);
        wordsView.showAllWords(words);
    };

    private Action1<Throwable> onError = e -> {
        wordsView.showProgress(false);
        wordsView.showError(e.getMessage());
    };
}
