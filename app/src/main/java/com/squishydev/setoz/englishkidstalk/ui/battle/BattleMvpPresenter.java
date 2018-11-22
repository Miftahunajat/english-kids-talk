package com.squishydev.setoz.englishkidstalk.ui.battle;

import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface BattleMvpPresenter<V extends BattleMvpView> extends MvpPresenter<V> {

    void postMatchOnline();

    void joinRandomMatch();

    void joinMatch();

    void observeScore();

    void addMyScore(Integer score);
}

