package com.squishydev.setoz.englishkidstalk.ui.challenge;

import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface ChallengeMvpPresenter<V extends ChallengeMvpView> extends MvpPresenter<V> {

    void getAllChalleges(Difficulty difficulty);

    void updateUserStar(int totalStars);
}

