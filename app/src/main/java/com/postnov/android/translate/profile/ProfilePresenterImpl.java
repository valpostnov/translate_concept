package com.postnov.android.translate.profile;

import com.postnov.android.translate.data.source.study.IStudyDataSource;
import com.postnov.android.translate.data.source.study.entity.GlobalStatistics;
import com.postnov.android.translate.data.source.study.entity.Statistics;
import com.postnov.android.translate.data.source.study.entity.Word;
import com.postnov.android.translate.profile.interfaces.ProfilePresenter;
import com.postnov.android.translate.profile.interfaces.ProfileView;

import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by platon on 25.07.2016.
 */
public class ProfilePresenterImpl implements ProfilePresenter {

    private ProfileView profileView;
    private CompositeSubscription subscriptions;
    private IStudyDataSource dataSource;

    public ProfilePresenterImpl(IStudyDataSource dataSource) {
        subscriptions = new CompositeSubscription();
        this.dataSource = dataSource;
    }

    @Override
    public void getWeekStatistics(int iterations) {

        profileView.showProgress(true);
        subscriptions.add(
                Observable.zip(dataSource.getWeekStatistics(), dataSource.getUnstudiedWords(iterations),
                (statistics, words) -> new GlobalStatistics(statistics, words.size()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError)
        );
    }

    @Override
    public void bind(ProfileView view) {
        profileView = view;
    }

    @Override
    public void unbind() {
        profileView = null;
    }

    @Override
    public void unsubscribe() {
        subscriptions.clear();
    }

    private Action1<GlobalStatistics> onNext = statistics -> {
        profileView.showProgress(false);
        profileView.showStatistics(statistics);
    };

    private Action1<Throwable> onError = e -> {
        profileView.showProgress(false);
        profileView.showError(e.getMessage());
    };
}
