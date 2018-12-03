package com.squishydev.setoz.englishkidstalk.ui.battle.battleselect;

import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;
import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface BattleMvpPresenter<V extends BattleMvpView> extends MvpPresenter<V> {

    void postMatchOnline();

    void joinRandomMatch();

    void joinMatch(Match matchId);

    void observeScore();

    void addMyScore(Integer score);

    void getAllMatches();

    void deleteMatch();

    void startMatch();
}

