package com.postnov.android.translate.profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.postnov.android.translate.R;
import com.postnov.android.translate.data.source.study.entity.Profile;
import com.postnov.android.translate.profile.interfaces.ProfileView;

public class ProfileFragment extends Fragment implements ProfileView {

    public ProfileFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void showProfile(Profile profile) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showError(String error) {

    }
}
