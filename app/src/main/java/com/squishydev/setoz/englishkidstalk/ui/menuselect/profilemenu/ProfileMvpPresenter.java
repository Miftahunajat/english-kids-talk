package com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu;

import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface ProfileMvpPresenter<V extends ProfileMvpView> extends MvpPresenter<V> {

    String getName();

    void getProfileUser();
}

