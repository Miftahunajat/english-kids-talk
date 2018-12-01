package com.squishydev.setoz.englishkidstalk.ui.battle.battlematch;

import com.google.firebase.database.ChildEventListener;
import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface BattleMatchMvpPresenter<V extends BattleMatchMvpView> extends MvpPresenter<V> {

    void getAllChallengesQuestion();

    void observingScoreChanges(String matchId);

    void observingScoreChanges(String matchId, ChildEventListener listener);

    void updateUserScore(int i);
}

