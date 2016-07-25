package com.postnov.android.translate.profile.interfaces;

import com.postnov.android.translate.base.BaseView;
import com.postnov.android.translate.data.source.study.entity.GlobalStatistics;
import com.postnov.android.translate.data.source.study.entity.Profile;

import java.util.List;

/**
 * Created by platon on 25.07.2016.
 */
public interface ProfileView extends BaseView {

    void showStatistics(GlobalStatistics statistics);
    void showProfileInfo(Profile profile);
}
