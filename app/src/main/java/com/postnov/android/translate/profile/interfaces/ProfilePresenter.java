package com.postnov.android.translate.profile.interfaces;

import com.postnov.android.translate.base.BasePresenter;


/**
 * Created by platon on 25.07.2016.
 */
public interface ProfilePresenter extends BasePresenter<ProfileView> {
    void getWeekStatistics(int iteration);
}
