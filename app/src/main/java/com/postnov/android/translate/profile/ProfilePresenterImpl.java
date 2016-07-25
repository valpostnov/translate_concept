package com.postnov.android.translate.profile;

import com.postnov.android.translate.data.source.study.IStudyDataSource;
import com.postnov.android.translate.data.source.study.entity.Profile;
import com.postnov.android.translate.profile.interfaces.ProfilePresenter;
import com.postnov.android.translate.profile.interfaces.ProfileView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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
                (statistics, words) -> new Profile(null, statistics, words.size()))
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

    private Action1<Profile> onNext = profile -> {
        profileView.showProgress(false);
        profileView.showProfile(profile);
    };

    private Action1<Throwable> onError = e -> {
        profileView.showProgress(false);
        profileView.showError(e.getMessage());
    };
}
